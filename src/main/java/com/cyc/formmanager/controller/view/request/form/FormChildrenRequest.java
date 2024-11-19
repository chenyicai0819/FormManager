package com.cyc.formmanager.controller.view.request.form;

import com.cyc.formmanager.entity.FillBlankAttribute;
import com.cyc.formmanager.entity.QuestionOption;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormMainResponse
 * Powered by GeorgeChen On 2023-09-11 12:04:13
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormChildrenRequest {
    private String code;
    private String userdefinecode;
    private String label;
    private String type;
    private String questionId;
    private Boolean required;
    private String value;
    @ApiModelProperty("多选默认值")
    private List<String> valueList;
    @ApiModelProperty("是否多选")
    private Boolean multiple;
    private String title;
    private List<QuestionOption> options;
    private List<FillBlankAttribute> fillBlanks;
}
