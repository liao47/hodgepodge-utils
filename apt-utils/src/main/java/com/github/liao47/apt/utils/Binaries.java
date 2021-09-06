package com.github.liao47.apt.utils;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import lombok.Getter;

/**
 * 二元操作工具
 * @author liao47
 * @date 2020/10/27 11:46
 */
public class Binaries {
    private TreeMaker treeMaker;

    @Getter
    private JCTree.JCExpression expression;

    private Binaries(TreeMaker treeMaker) {
        this.treeMaker = treeMaker;
    }

    /**
     * 创建
     * @param treeMaker
     * @return
     */
    public static Binaries create(TreeMaker treeMaker) {
        return new Binaries(treeMaker);
    }

    /**
     * 连接
     * @param expression
     * @return
     */
    public Binaries concat(JCTree.JCExpression expression) {
        if (this.expression == null) {
            this.expression = expression;
        } else {
            this.expression = treeMaker.Exec(treeMaker.Binary(JCTree.Tag.PLUS, this.expression, expression))
                    .getExpression();
        }
        return this;
    }

    /**
     * 连接
     * @param str
     * @return
     */
    public Binaries concat(String str) {
        return this.concat(this.treeMaker.Literal(str));
    }
}
