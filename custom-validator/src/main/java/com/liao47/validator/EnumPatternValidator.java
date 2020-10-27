package com.liao47.validator;

import com.liao47.able.EnumPatternAble;
import com.liao47.annotation.EnumPattern;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 枚举限定校验器
 * @author liao47
 * @date 2020/10/27 15:13
 */
public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Object> {

    /**
     * 限定值
     */
    private Set<Object> values;

    @Override
    public void initialize(EnumPattern constraintAnnotation) {
        values = new HashSet<>();
        Class<? extends Enum> enumClass = constraintAnnotation.value();
        if (!constraintAnnotation.ignorePatternAble() && EnumPatternAble.class.isAssignableFrom(enumClass)) {
            //枚举实现了EnumPatternAble接口
            for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                values.add(((EnumPatternAble) anEnum).getPatternValue());
            }
        } else if (StringUtils.isEmpty(constraintAnnotation.fieldName())) {
            for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                values.add(anEnum.name());
            }
        } else {
            try {
                Method method = enumClass.getMethod("get" + StringUtils.capitalize(constraintAnnotation.fieldName()));
                for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                    values.add(method.invoke(anEnum));
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Fail to invoke filed[%s] getter in [%s]",
                        constraintAnnotation.fieldName(), enumClass.getCanonicalName()), e);
            }
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(Objects.toString(value, null))) {
            return true;
        }
        for (Object obj : values) {
            if (value.equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
