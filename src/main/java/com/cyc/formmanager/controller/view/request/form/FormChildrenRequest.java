package com.cyc.formmanager.controller.view.request.form;

import com.cyc.formmanager.entity.FillBlankAttribute;
import com.cyc.formmanager.entity.QuestionOption;
import com.cyc.formmanager.entity.form.FormFillBlankDO;
import com.cyc.formmanager.entity.form.FormMainDO;
import com.cyc.formmanager.entity.form.FormSelectDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
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

    public FormMainDO covertFormMainDO(){
        FormMainDO formMainDO = new FormMainDO();
        if (this.code != null) {
            formMainDO.setCode(this.code);
        }
        if (this.userdefinecode != null) {
            formMainDO.setUserDefineCode(this.userdefinecode);
        }
        if (this.label != null) {
            formMainDO.setLabel(this.label);
        }
        if (this.type != null) {
            formMainDO.setType(this.type);
        }
        if (this.questionId != null) {
            formMainDO.setQuestionId(this.questionId);
        }
        if (this.required != null) {
            formMainDO.setRequired(this.required);
        }
        if (this.value != null) {
            formMainDO.setValue(this.value);
        }
        if (this.title != null) {
            formMainDO.setTitle(this.title);
        }
        return formMainDO;
    }

    public List<FormSelectDO> covertFormSelectDOList(){
        List<FormSelectDO> formSelectDOList = new ArrayList<>();

        for (QuestionOption option : this.options) {
            FormSelectDO formSelectDO = new FormSelectDO();
            formSelectDO.setCode(option.getCode());
            formSelectDO.setUserDefineCode(option.getUserDefineCode());
            formSelectDO.setTitle(option.getTitle());
            formSelectDO.setDefaultOption(option.getDefaultOption());
            formSelectDO.setShowContent(option.getShowContent());
            formSelectDOList.add(formSelectDO);
        }
        return formSelectDOList;
    }

    public List<FormFillBlankDO> covertFormFillBlankDOList(){
        List<FormFillBlankDO> formFillBlankDOList = new ArrayList<>();

        for (FillBlankAttribute fillBlankAttribute : this.fillBlanks) {
            FormFillBlankDO formFillBlankDO = new FormFillBlankDO();
            formFillBlankDO.setCode(fillBlankAttribute.getCode());
            formFillBlankDO.setPrefix(fillBlankAttribute.getPrefix());
            formFillBlankDO.setDataType(fillBlankAttribute.getDataType());
            formFillBlankDO.setNumericScale(fillBlankAttribute.getNumericScale());
            formFillBlankDO.setDateType(fillBlankAttribute.getDateType());
            formFillBlankDO.setMin(fillBlankAttribute.getMin());
            formFillBlankDO.setMax(fillBlankAttribute.getMax());
            formFillBlankDO.setSuffix(fillBlankAttribute.getSuffix());
            formFillBlankDO.setSoftCheck(fillBlankAttribute.getSoftCheck());
            formFillBlankDO.setPrefixSwitch(fillBlankAttribute.getPrefixSwitch());
            formFillBlankDO.setSuffixSwitch(fillBlankAttribute.getSuffixSwitch());
            formFillBlankDO.setValue(fillBlankAttribute.getValue());
            formFillBlankDOList.add(formFillBlankDO);
        }
        return formFillBlankDOList;
    }
}
