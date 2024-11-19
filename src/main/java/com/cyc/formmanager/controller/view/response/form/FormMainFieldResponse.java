package com.cyc.formmanager.controller.view.response.form;

import lombok.Data;

/**
 * Project : registration-project - FormMainFieldResponse
 * Powered by GeorgeChen On 2023-11-18 15:30:59
 * 表单字段信息
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormMainFieldResponse {
    /**
     * 表单字段名
     */
    private String title;

    /**
     * 表单类型
     */
    private String caseType;
    private String label;
}
