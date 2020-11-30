package com.github.liao47.validator;

import com.github.liao47.validator.annotation.IDCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 身份证号码校验器
 * @author liao47
 * @date 2020/11/30 10:35
 */
public class IDCardValidator implements ConstraintValidator<IDCard, CharSequence> {
    /**
     * 校验失败详情变量
     */
    public static final String DETAIL_MSG_KEY = "{detail}";

    /**
     * 18位身份证号码正则
     */
    private static final Pattern ID18_PATTERN = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))" +
            "((0[1-9])|([1|2]\\d)|(3[0-1]))\\d{3}([\\dxX])$");

    /**
     * 15位身份证号码正则
     */
    private static final Pattern ID15_PATTERN = Pattern.compile("^[1-9]\\d{5}\\d{2}((0[1-9])|(1[0-2]))" +
            "((0[1-9])|([1|2]\\d)|(3[0-1]))\\d{3}$");

    /**
     * 18位身份证中最后一位校验码
     */
    private static final char[] VERIFY_CODE = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 18位身份证中，各个数字的生成校验码时的权值
     */
    private static final int[] VERIFY_CODE_WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 第二代身份证号码长度
     */
    private static final int SECOND_ID_CARD_LENGTH = 18;

    /**
     * 是否弱校验
     */
    private boolean weak;

    @Override
    public void initialize(IDCard constraintAnnotation) {
        this.weak = constraintAnnotation.weak();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        if (!ID18_PATTERN.matcher(value).matches() && !ID15_PATTERN.matcher(value).matches()) {
            this.buildMsg(context, "格式错误");
            return false;
        }
        if (this.weak) {
            return true;
        }

        if (value.length() == SECOND_ID_CARD_LENGTH
                && Character.toUpperCase(value.charAt(SECOND_ID_CARD_LENGTH - 1)) != calculateVerifyCode(value)) {
            this.buildMsg(context, "校验码校验不通过");
            return false;
        }
        return true;
    }

    /**
     * 消息构建
     * @param context
     * @param msg
     */
    private void buildMsg(ConstraintValidatorContext context, String msg) {
        String defaultMsg = context.getDefaultConstraintMessageTemplate();
        if (StringUtils.contains(defaultMsg, DETAIL_MSG_KEY)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(defaultMsg.replace(DETAIL_MSG_KEY, msg))
                    .addConstraintViolation();
        }
    }

    /**
     * 校验码（第十八位数）：
     *
     * 十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0...16 ，先对前17位数字的权求和；
     * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2;
     * 计算模 Y = mod(S, 11)< 通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
     * @param cardNumber
     * @return
     */
    private static char calculateVerifyCode(CharSequence cardNumber){
        int sum = 0;
        for (int i = 0; i < SECOND_ID_CARD_LENGTH - 1; i++){
            char c = cardNumber.charAt(i);
            sum += (c - '0') * VERIFY_CODE_WEIGHT[i];
        }
        return VERIFY_CODE[sum % 11];
    }
}
