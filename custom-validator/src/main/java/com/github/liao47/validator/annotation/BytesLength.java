package com.github.liao47.validator.annotation;



import com.github.liao47.validator.BytesLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 字节长度校验
 * @author liao47
 * @date 2020/10/27 15:12
 */
@Documented
@Constraint(validatedBy = {BytesLengthValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface BytesLength {
    /**
     * 最新长度
     * @return
     */
    int min() default 0;

    /**
     * 最大长度
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 字符集<br>
     *     默认GBK，中文算2个字节长度
     *     UTF-8，中文算3个字节长度
     * @return
     */
    String charset() default "GBK";

    String message() default "字节长度校验不通过";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
