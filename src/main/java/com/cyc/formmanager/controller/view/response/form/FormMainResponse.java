package com.cyc.formmanager.controller.view.response.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormChildrenResponse
 * Powered by GeorgeChen On 2023-11-08 16:15:23
 * 表单列表内容
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormMainResponse {

    /**
     * 表单列表内容
     */
    private List<FormChildrenResponse> children;

    /**
     * 表单列表ID
     */
    private String childrenId;

    /**
     * 是否可配置
     */
    private Boolean isConfig;
}
