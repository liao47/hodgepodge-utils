package com.liao47.validator;

import com.liao47.annotation.BytesLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.charset.Charset;

/**
 * 字节长度校验
 * @author liao47
 * @date 2020/10/27 15:12
 */
public class BytesLengthValidator implements ConstraintValidator<BytesLength, CharSequence> {
    /**
     * 最小长度
     */
    private int min;

    /**
     * 最大长度
     */
    private int max;

    /**
     * 字符集
     */
    private Charset charset;

    @Override
    public void initialize(BytesLength constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        charset = Charset.forName(constraintAnnotation.charset());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        int length = value.toString().getBytes(charset).length;
        return length >= min && length <= max;
    }
}
