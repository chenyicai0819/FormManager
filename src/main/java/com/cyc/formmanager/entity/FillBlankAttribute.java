package com.cyc.formmanager.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FillBlankAttribute {
    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("选项前文字")
    private String prefix;

    @ApiModelProperty("填空类型(数字-number,日期-time,文本-text,下拉单选-single,下拉多选-multi)")
    private String dataType;

    @ApiModelProperty("小数位数限制")
    private Integer numericScale;

    @ApiModelProperty("日期范围类型(1-具体时间 2-答卷当天时间 3-答卷日期前后x天")
    private String dateType;

    @ApiModelProperty("范围校验最小值")
    private String min;

    @ApiModelProperty("范围校验最大值")
    private String max;

    @ApiModelProperty("选项后文字")
    private String suffix;

    @ApiModelProperty("软校验")
    private Boolean softCheck;

    @ApiModelProperty("选项前文字开关")
    private Boolean prefixSwitch;

    @ApiModelProperty("选项后文字开关")
    private Boolean suffixSwitch;

    @ApiModelProperty("默认值")
    private String value;

}
