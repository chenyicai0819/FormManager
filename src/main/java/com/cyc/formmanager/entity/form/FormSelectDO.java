package com.cyc.formmanager.entity.form;

import lombok.Data;

import java.io.Serializable;

/**
 * t_form_select
 * @author 
 */
@Data
public class FormSelectDO implements Serializable {
    /**
     * 选项编码
     */
    private String code;

    /**
     * 用户自定义编码
     */
    private String userDefineCode;

    /**
     * 选项内容
     */
    private String title;

    /**
     * 是否为默认选项
     */
    private Boolean defaultOption;

    /**
     * 用于前端回显是否填空内容
     */
    private Boolean showContent;

    private static final long serialVersionUID = 1L;
}