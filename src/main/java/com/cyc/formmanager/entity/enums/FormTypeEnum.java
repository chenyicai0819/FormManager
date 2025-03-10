package com.cyc.formmanager.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Project : registration-project - FormTypeEnum
 * Powered by GeorgeChen On 2023-11-08 15:23:51
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/

@AllArgsConstructor
@Getter
public enum FormTypeEnum {

    RADIO("radio","单选题"),
    COMBO_BOX("comboBox","下拉框"),
    SIGN_NAME("signName","签名题"),
    SINGLE_BLANK("singleBlank","单项填空"),
    CHECK_BOX("checkbox","多选题"),
    TEXTAREA("textarea","文本框");

    private String code;
    private String message;

    // 判断输入的枚举是属于哪一类
    public static String getType(String code) {
        if (Objects.equals(code, RADIO.code)
            || Objects.equals(code, COMBO_BOX.code)) {
            return "QuestionOption";
        } else {
            return "FillBlankAttribute";
        }
    }
}
