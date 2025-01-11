package com.cyc.formmanager.entity.form;

import lombok.Data;

import java.io.Serializable;

/**
 * t_form_fill_blank
 * @author 
 */
@Data
public class FormFillBlankDO implements Serializable {
    /**
     * 编码
     */
    private String code;

    /**
     * 选项前文字
     */
    private String prefix;

    /**
     * 填空类型(数字-number,日期-time,文本-text,下拉单选-single,下拉多选-multi)
     */
    private String dataType;

    /**
     * 小数位数限制
     */
    private Integer numericScale;

    /**
     * 日期范围类型(1-具体时间 2-答卷当天时间 3-答卷日期前后x天
     */
    private String dateType;

    /**
     * 范围校验最小值
     */
    private String min;

    /**
     * 范围校验最大值
     */
    private String max;

    /**
     * 选项后文字
     */
    private String suffix;

    /**
     * 软校验
     */
    private Boolean softCheck;

    /**
     * 选项前文字开关
     */
    private Boolean prefixSwitch;

    /**
     * 选项后文字开关
     */
    private Boolean suffixSwitch;

    /**
     * 默认值
     */
    private String value;

    private static final long serialVersionUID = 1L;
}