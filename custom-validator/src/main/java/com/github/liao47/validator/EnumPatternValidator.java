package com.github.liao47.validator;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.validator.able.EnumPatternAble;
import com.github.liao47.validator.annotation.EnumPattern;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 枚举限制校验器
 * @author liao47
 * @date 2020/10/27 15:13
 */
public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Object> {

    /**
     * 限制值集合
     */
    private Set<String> values;

    @Override
    public void initialize(EnumPattern enumPattern) {
        values = new HashSet<>();
        if (StringUtils.isEmpty(enumPattern.fieldName())) {
            Class<? extends Enum> enumClass = enumPattern.value();
            if (EnumPatternAble.class.isAssignableFrom(enumClass)) {
                //枚举实现了EnumPatternAble接口
                for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                    values.add(((EnumPatternAble) anEnum).getPatternValue());
                }
            } else {
                for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                    values.add(anEnum.name());
                }
            }
        } else {
            //反射取值
            this.reflectGetValues(enumPattern);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof Collection) {
            for (Object val : (Collection<?>) value) {
                if (!this.isValid(val)) {
                    return false;
                }
            }
            return true;
        }
        return this.isValid(value);
    }

    private boolean isValid(Object value) {
        return StringUtils.isEmpty(Objects.toString(value, null)) || values.contains(value.toString());
    }

    /**
     * 反射取值
     * @param enumPattern
     */
    private void reflectGetValues(EnumPattern enumPattern) {
        try {
            String[] arr = enumPattern.fieldName().split("\\.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = "get" + StringUtils.capitalize(arr[i]);
            }

            for (Enum<?> anEnum : enumPattern.value().getEnumConstants()) {
                Object obj = anEnum;
                for (String getter : arr) {
                    Method method = obj.getClass().getMethod(getter);
                    obj = method.invoke(obj);
                    if (obj == null) {
                        break;
                    }
                }
                values.add(Objects.toString(obj, null));
            }
        } catch (Exception e) {
            throw new CustomException(String.format("Failed to invoke filed[%s] getter in [%s]",
                    enumPattern.fieldName(), enumPattern.value().getCanonicalName()));
        }
    }
}
