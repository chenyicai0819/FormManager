package com.cyc.formmanager.controller.view.response.form;

import lombok.Data;

/**
 * Project : registration-project - FormNameResponse
 * Powered by GeorgeChen On 2023-09-19 15:00:28
 * 表单名
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormNameResponse {
    /**
     * 表单编码
     */
    private String code;

    /**
     * 表单名
     */
    private String label;
}
