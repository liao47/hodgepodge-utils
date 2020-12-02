package com.github.liao47.validator.annotation;

import com.github.liao47.validator.IDCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 身份证号码校验
 * @author liao47
 * @date 2020/11/30 10:35
 */
@Documented
@Constraint(validatedBy = {IDCardValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface IDCard {

    /**
     * 描述详情键
     */
    String DETAIL_KEY = "{detail}";

    /**
     * 是否弱校验<br>
     *     只校验格式
     * @return
     */
    boolean weak() default false;

    /**
     * 描述
     * @return
     */
    String message() default "身份证号码校验不通过:" + DETAIL_KEY;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
