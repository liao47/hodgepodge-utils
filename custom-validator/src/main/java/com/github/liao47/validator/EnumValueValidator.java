package com.github.liao47.validator;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.validator.able.EnumValueAble;
import com.github.liao47.validator.annotation.EnumValue;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 枚举值校验器
 * @author liao47
 * @date 2020/10/27 15:13
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {

    /**
     * 限制值集合
     */
    private Set<String> values;

    @Override
    public void initialize(EnumValue enumValue) {
        values = new HashSet<>();
        if (StringUtils.isEmpty(enumValue.fieldName())) {
            Class<? extends Enum> enumClass = enumValue.value();
            if (EnumValueAble.class.isAssignableFrom(enumClass)) {
                //枚举实现了EnumValueAble接口
                for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                    values.add(((EnumValueAble) anEnum).getEnumValue());
                }
            } else {
                for (Enum<?> anEnum : enumClass.getEnumConstants()) {
                    values.add(anEnum.name());
                }
            }
        } else {
            //反射取值
            this.reflectGetValues(enumValue);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof Collection) {
            for (Object val : (Collection<?>) value) {
                if (!this.isValid(val)) {
                    this.buildMsg(context, val);
                    return false;
                }
            }
            return true;
        }

        if (this.isValid(value)) {
            return true;
        }
        this.buildMsg(context, value);
        return false;
    }

    private boolean isValid(Object value) {
        return StringUtils.isEmpty(Objects.toString(value, null)) || values.contains(value.toString());
    }

    /**
     * 反射取值
     * @param enumValue
     */
    private void reflectGetValues(EnumValue enumValue) {
        try {
            String[] arr = enumValue.fieldName().split("\\.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = "get" + StringUtils.capitalize(arr[i]);
            }

            for (Enum<?> anEnum : enumValue.value().getEnumConstants()) {
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
            throw new CustomException(String.format("获取枚举值失败[%s.%s]",
                    enumValue.value().getCanonicalName(), enumValue.fieldName()));
        }
    }

    /**
     * 构建错误信息
     * @param context
     * @param value
     */
    private void buildMsg(ConstraintValidatorContext context, Object value) {
        String msg = context.getDefaultConstraintMessageTemplate();
        msg = StringUtils.replace(msg, "{}", Objects.toString(value));
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
    }
}
