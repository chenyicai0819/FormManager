package com.cyc.formmanager.controller.view.request.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormResponse
 * Powered by GeorgeChen On 2023-09-11 12:02:36
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormRequest {
    private String title;
    private Boolean moduleTab;
    private Boolean disabled;
    private List<FormMainRequest> main;
    private List<FormTabDataRequest> tabData;
}
