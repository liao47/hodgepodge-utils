package com.liao47.apt.annotation;

import com.liao47.common.enums.Brackets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 生成toString<br>
 *     使用后会替换lombok或者手写的toString，
 *     可配合@Mask做掩码操作
 *     可配置@Format格式化
 * @author liao47
 * @date 2020/10/27 11:45
 * @see Mask
 * @see Format
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface ToString {

    /**
     * 是否包含字段名
     * @return
     */
    boolean includeFieldNames() default true;

    /**
     * 排除字段<br>
     *     如果of与exclude同时不为空，则以of为准，exclude不生效
     * @return
     */
    String[] exclude() default {};

    /**
     * 使用的字段
     * @return
     */
    String[] of() default {};

    /**
     * 是否调用super的toString
     * @return
     */
    boolean callSuper() default false;

    /**
     * 是否不使用getter获取值
     * @return
     */
    boolean doNotUseGetters() default false;

    /**
     * 是否分层
     * @return
     */
    boolean layer() default true;

    /**
     * 括号
     * @return
     */
    Brackets brackets() default Brackets.PARENTHESES;

    /**
     * 排序字段<br>
     *     layer = true 分层的情况下，只对本类字段进行排序，不会影响父类toString
     *     com.liao47.common.constants.OrderConstants
     *     常量指定不在列表内其他字段的排序位置和排序方式，填写多个常量以第一个为准，其他忽略，例：
     *         类中包含字段：c, a, b, y, x，则：orders =
     *         {"x", OrderConstants.DEFAULT, "y"} → {"x", "c", "a", "b", "y"}
     *         {OrderConstants.ASC, "x", "y"} → {"a", "b", "c", "x", "y"}
     *         {"x", "y", OrderConstants.DESC} → {"x", "y", "c", "b", "a"}
     *         OrderConstants.ASC → {"a", "b", "c", "x", "y"}
     * @return
     */
    String[] orders() default {};
}
