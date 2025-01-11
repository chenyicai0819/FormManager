package com.cyc.formmanager.service;

import com.cyc.formmanager.controller.view.request.form.FormMainRequest;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : FormManager - FormService
 * Powered by GeorgeChen On 2024-11-20 00:31:22
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/

public interface FormService {

    List<FormResponse> getForm(char type);

    int addForm(FormMainRequest request);

    int dropForm(List<String> code);
}
