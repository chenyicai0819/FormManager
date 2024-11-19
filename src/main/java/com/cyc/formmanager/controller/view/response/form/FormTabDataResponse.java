package com.cyc.formmanager.controller.view.response.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormTabDataResponse
 * Powered by GeorgeChen On 2023-11-08 16:16:49
 * 分类表单列表
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormTabDataResponse {

    /**
     * 表单类别标题
     */
    private String title;

    /**
     * 表单列表
     */
    private List<FormMainResponse> main;
}
