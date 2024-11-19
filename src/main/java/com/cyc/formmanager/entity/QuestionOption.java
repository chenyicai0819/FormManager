package com.cyc.formmanager.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 选择题选项详情
 */
@Data
public class QuestionOption {
    @ApiModelProperty("选项编码")
    private String code;

    @ApiModelProperty("用户自定义编码")
    private String userDefineCode;

    @ApiModelProperty("选项内容")
    private String title;

    @ApiModelProperty("是否为默认选项")
    private Boolean defaultOption;

    @ApiModelProperty("用于前端回显是否填空内容")
    private Boolean showContent;
}
