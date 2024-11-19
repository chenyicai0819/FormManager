package com.cyc.formmanager.controller.view.request.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormChildrenResponse
 * Powered by GeorgeChen On 2023-11-08 16:15:23
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormMainRequest {
    private List<FormChildrenRequest> children;
    private String childrenId;
    private String childrenChildrenId;
    private String rpotcNo;
    private Boolean isConfig;
    private String modelTitle;
}
