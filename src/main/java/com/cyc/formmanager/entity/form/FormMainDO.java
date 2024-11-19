package com.cyc.formmanager.entity.form;

import lombok.Data;

import java.io.Serializable;

/**
 * t_form_main
 * @author 
 */
@Data
public class FormMainDO implements Serializable {
    /**
     * 问题编码
     */
    private String code;

    /**
     * 用户自定义编码
     */
    private String userdefinecode;

    /**
     * 问题内容
     */
    private String label;

    /**
     * 问题类型
     */
    private String type;

    /**
     * 类型ID
     */
    private String questionId;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 答案
     */
    private String value;

    /**
     * 所属标题
     */
    private String title;

    private static final long serialVersionUID = 1L;
}