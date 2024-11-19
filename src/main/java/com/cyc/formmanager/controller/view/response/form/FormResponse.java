package com.cyc.formmanager.controller.view.response.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormResponse
 * Powered by GeorgeChen On 2023-09-11 12:02:36
 * 表单第一层内容
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormResponse {
    /**
     * 标题
     */
    private String title;


    private Boolean moduleTab;

    /**
     * 是否禁用
     */
    private Boolean disabled;

    /**
     * 表单列表
     */
    private List<FormMainResponse> main;

    /**
     * 分类表单列表
     */
    private List<FormTabDataResponse> tabData;

}
