package com.github.liao47.validator.annotation;


import com.github.liao47.validator.EnumValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 枚举值校验
 * @author liao47
 * @date 2020/10/27 15:12
 */
@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface EnumValue {

    /**
     * 枚举类
     * @return
     */
    Class<? extends Enum> value();

    /**
     * 校验的枚举字段名称<br>
     * 支持多级成员变量名称：person.name
     * 如为空：
     *     枚举实现了EnumValueAble接口，取值getEnumValue()，
     *     否则取值name()
     * @return
     */
    String fieldName() default "";

    /**
     * 描述
     * @return
     */
    String message() default "不在取值范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
