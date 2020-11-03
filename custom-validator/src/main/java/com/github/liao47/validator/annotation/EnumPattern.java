package com.github.liao47.validator.annotation;


import com.github.liao47.validator.EnumPatternValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 枚举限制校验
 * @author liao47
 * @date 2020/10/27 15:12
 */
@Documented
@Constraint(validatedBy = {EnumPatternValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface EnumPattern {

    /**
     * 枚举类
     * @return
     */
    Class<? extends Enum> value();

    /**
     * 校验的枚举字段值<br>
     *     如果枚举实现了com.github.liao47.able.EnumPatternAble接口，则忽略此值，取值getPatternValue()
     *     如果值为空，则取值name()
     *     否则，通过反射使用getter获取值
     * @return
     */
    String fieldName() default "";

    /**
     * 是否忽略枚举限制校验能力接口<br>
     *     是否忽略枚举实现的com.github.liao47.able.EnumPatternAble接口，强制使用fieldName控制获取值
     * @return
     */
    boolean ignorePatternAble() default false;

    /**
     * 描述
     * @return
     */
    String message() default "不在取值范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
