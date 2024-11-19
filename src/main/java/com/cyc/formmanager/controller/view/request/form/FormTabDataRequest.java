package com.cyc.formmanager.controller.view.request.form;

import lombok.Data;

import java.util.List;

/**
 * Project : registration-project - FormTabDataResponse
 * Powered by GeorgeChen On 2023-11-08 16:16:49
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormTabDataRequest {
    private String title;
    private List<FormMainRequest> main;
}
