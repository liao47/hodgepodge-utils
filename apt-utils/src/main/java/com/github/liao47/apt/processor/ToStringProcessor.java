package com.github.liao47.apt.processor;

import com.github.liao47.apt.annotation.Format;
import com.github.liao47.apt.annotation.Mask;
import com.github.liao47.apt.annotation.ToString;
import com.github.liao47.apt.utils.Annotations;
import com.github.liao47.apt.utils.Binaries;
import com.github.liao47.apt.utils.Formatter;
import com.github.liao47.apt.utils.VarComparator;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * toString processor
 * @author liao47
 * @date 2020/10/27 11:50
 */
public class ToStringProcessor extends AbstractProcessor {
    private Messager messager;
    private JavacTrees trees;
    private TreeMaker treeMaker;
    private Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //字段注解缓存初始化
        Annotations.init(roundEnv);
        //处理ToString注解
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(ToString.class);
        for (final Element element : set) {
            if (!(element instanceof TypeElement)) {
                continue;
            }
            final TypeElement typeElement = (TypeElement) element;
            ToString toString = typeElement.getAnnotation(ToString.class);
            final java.util.List<JCTree.JCVariableDecl> variableList = new ArrayList<>();
            if (toString.callSuper() && !toString.layer()) {
                //不分层则直接获取所有父类变量生成ToString
                this.addSuperVariable(typeElement, variableList);
            }
            JCTree jcTree = trees.getTree(typeElement);
            jcTree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                    java.util.List<JCTree.JCVariableDecl> jcVariableDeclList = new ArrayList<>();
                    for (JCTree tree : jcClassDecl.defs) {
                        if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                            jcVariableDeclList.add((JCTree.JCVariableDecl) tree);
                        }
                    }
                    jcVariableDeclList.addAll(variableList);
                    jcClassDecl.defs = removeExistsMethod(jcClassDecl.defs)
                            .append(makeToStringMethod(typeElement, jcVariableDeclList));
                    super.visitClassDef(jcClassDecl);

                    messager.printMessage(Diagnostic.Kind.NOTE, String.format("Generated %s.toString successful.",
                            typeElement.getQualifiedName()));
                }

            });
        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(ToString.class.getCanonicalName());
        set.add(Mask.class.getCanonicalName());
        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 获取父类
     * @param element
     * @return
     */
    private TypeElement getSuperClass(TypeElement element) {
        TypeMirror parent = element.getSuperclass();
        if (parent instanceof DeclaredType) {
            Element elt = ((DeclaredType) parent).asElement();
            if (elt instanceof TypeElement) {
                return (TypeElement) elt;
            }
        }
        return null;
    }

    /**
     * 添加父类变量
     * @param typeElement
     * @param list
     */
    private void addSuperVariable(final TypeElement typeElement, final java.util.List<JCTree.JCVariableDecl> list) {
        TypeElement superClass = this.getSuperClass(typeElement);
        if (superClass == null || Object.class.getCanonicalName().equals(superClass.getQualifiedName().toString())) {
            return;
        }

        JCTree jcTree = trees.getTree(superClass);
        if (jcTree != null) {
            jcTree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                    for (JCTree tree : jcClassDecl.defs) {
                        if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                            JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl) tree;
                            list.add(jcVariableDecl);
                        }
                    }
                }
            });
        } else {
            //没有源码，为引入包，手动创建相应变量
            this.makeVars(superClass, list);
        }
        this.addSuperVariable(superClass, list);
    }

    /**
     * 定义生成成员变量
     * @param typeElement
     * @param list
     */
    private void makeVars(TypeElement typeElement, final java.util.List<JCTree.JCVariableDecl> list) {
        for (Element element : typeElement.getEnclosedElements()) {
            //非静态变量
            if (ElementKind.FIELD.equals(element.getKind()) && !element.getModifiers().contains(Modifier.STATIC)) {
                JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PRIVATE);
                Name fieldName = names.fromString(element.getSimpleName().toString());
                JCTree.JCExpression fieldType = memberAccess(((TypeElement) element.getEnclosingElement())
                        .getQualifiedName().toString());
                list.add(treeMaker.VarDef(modifiers, fieldName, fieldType, null));
            }
        }
    }

    /**
     * 生成toString
     *
     * @param element
     * @param jcVariableDeclList
     * @return
     */
    private JCTree.JCMethodDecl makeToStringMethod(TypeElement element,
                                                   java.util.List<JCTree.JCVariableDecl> jcVariableDeclList) {
        final ToString annotation = element.getAnnotation(ToString.class);
        if (annotation.orders().length > 0) {
            jcVariableDeclList.sort(new VarComparator(annotation.orders()));
        }

        Binaries binaries = Binaries.create(treeMaker);
        boolean hasFront = false;
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(element.getSimpleName()).append(annotation.brackets().getOpening());

        if (annotation.callSuper() && annotation.layer()) {
            if (annotation.includeFieldNames()) {
                tempStr.append("super=");
            }
            binaries.concat(tempStr.toString())
                    .concat(treeMaker.Apply(List.nil(), memberAccess("super.toString"), List.nil()));
            hasFront = true;
            tempStr = new StringBuilder();
        }

        java.util.List<String> of = Arrays.asList(annotation.of());
        java.util.List<String> exclude = Arrays.asList(annotation.exclude());
        for (JCTree.JCVariableDecl jcVariableDecl : jcVariableDeclList) {
            if (this.isExcludedField(jcVariableDecl, of, exclude)) {
                continue;
            }

            if (hasFront) {
                tempStr.append(", ");
            }
            if (annotation.includeFieldNames()) {
                tempStr.append(jcVariableDecl.getName()).append('=');
            }
            binaries.concat(tempStr.toString());

            binaries.concat(this.getFieldValue(element, jcVariableDecl, !annotation.doNotUseGetters()));

            hasFront = true;
            tempStr = new StringBuilder();
        }
        tempStr.append(annotation.brackets().getClosing());
        binaries.concat(tempStr.toString());

        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(treeMaker.Return(binaries.getExpression()));
        //定义方法体
        JCTree.JCBlock methodBody = treeMaker.Block(0, statements.toList());

        //方法的访问级别
        JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);
        //定义方法名
        Name methodName = this.getMethodName();
        //定义返回值类型
        JCTree.JCExpression returnMethodType = memberAccess(String.class.getCanonicalName());
        List<JCTree.JCTypeParameter> methodGenericParams = List.nil();
        //设置入参
        List<JCTree.JCVariableDecl> parameters = List.nil();
        List<JCTree.JCExpression> throwsClauses = List.nil();

        return treeMaker.MethodDef(modifiers, methodName, returnMethodType, methodGenericParams, parameters,
                throwsClauses, methodBody, null);
    }

    /**
     * 创建 域/方法 的多级访问
     * @param components
     * @return
     */
    private JCTree.JCExpression memberAccess(String components) {
        String[] componentArray = components.split("\\.");
        JCTree.JCExpression expr = treeMaker.Ident(names.fromString(componentArray[0]));
        for (int i = 1; i < componentArray.length; i++) {
            expr = treeMaker.Select(expr, names.fromString(componentArray[i]));
        }
        return expr;
    }

    /**
     * 获取方法名
     * @return
     */
    private Name getMethodName() {
        return names.fromString("toString");
    }

    /**
     * 去除已有的toString方法
     * @param defs
     * @return
     */
    private List<JCTree> removeExistsMethod(List<JCTree> defs) {
        for (JCTree def : defs) {
            if (def instanceof JCTree.JCMethodDecl
                    && ((JCTree.JCMethodDecl) def).getName().toString().equals(getMethodName().toString())) {
                return List.filter(defs, def);
            }
        }
        return defs;
    }

    /**
     * 是否排除的字段
     * @param var
     * @param of
     * @param exclude
     * @return
     */
    private boolean isExcludedField(JCTree.JCVariableDecl var, java.util.List<String> of, java.util.List<String>
            exclude) {
        //排除static字段
        boolean isExcluded = (var.mods.flags & Flags.STATIC) != 0;
        //of不为空，of中没有的字段排除
        isExcluded = isExcluded || !of.isEmpty() && !of.contains(var.getName().toString());
        //of为空，才排除exclude的字段
        isExcluded = isExcluded || of.isEmpty() && exclude.contains(var.getName().toString());
        return isExcluded;
    }

    /**
     * 获取字段值
     * @param element
     * @param var
     * @param useGetters
     * @return
     */
    private JCTree.JCExpression getFieldValue(TypeElement element, JCTree.JCVariableDecl var, boolean useGetters) {
        JCTree.JCExpression value;
        if (useGetters) {
            value = treeMaker.Apply(List.nil(), this.accessGetter(var), List.nil());
        } else {
            value = treeMaker.Select(treeMaker.Ident(names.fromString("this")), var.getName());
        }

        //格式化
        Format format = Annotations.get(Format.class, element.getQualifiedName(), var.getName().toString());
        if (format != null) {
            value = treeMaker.Apply(List.of(memberAccess(Object.class.getCanonicalName()),
                            memberAccess(String.class.getCanonicalName())),
                    memberAccess(Formatter.class.getCanonicalName() + ".format"),
                    List.of(value, treeMaker.Literal(format.pattern())));
        }

        //掩码处理
        Mask mask = Annotations.get(Mask.class, element.getQualifiedName(), var.getName().toString());
        if (mask != null) {
            //maskChar使用Character有兼容性问题，暂使用String处理
            value = treeMaker.Apply(List.of(memberAccess(Object.class.getCanonicalName()),
                            memberAccess(Integer.class.getCanonicalName()),
                            memberAccess(Integer.class.getCanonicalName()),
                            memberAccess(String.class.getCanonicalName())),
                    memberAccess(Formatter.class.getCanonicalName() + ".mask"),
                    List.of(value, treeMaker.Literal(mask.prefix()), treeMaker.Literal(mask.suffix()), treeMaker
                            .Literal(String.valueOf(mask.maskChar()))));
        }
        return value;
    }

    /**
     * 访问getter
     * @param var
     * @return
     */
    private JCTree.JCExpression accessGetter(JCTree.JCVariableDecl var) {
        String getter;
        String name = var.getName().toString();
        if (var.vartype != null && "boolean".equals(var.vartype.toString())) {
            if (name.startsWith("is") && name.length() > 2 && !Character.isLowerCase(name.charAt(2))) {
                getter = name;
            } else {
                getter = "is" + StringUtils.capitalize(name);
            }
        } else {
            getter = "get" + StringUtils.capitalize(name);
        }
        return treeMaker.Select(treeMaker.Ident(names.fromString("this")), names.fromString(getter));
    }
}
