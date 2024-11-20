package com.cyc.formmanager.service.impl;

import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.service.FormService;
import com.cyc.formmanager.utils.FormUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : FormManager - FormServiceImpl
 * Powered by GeorgeChen On 2024-11-20 00:31:41
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Slf4j
@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormUtils formUtils;

    @Override
    public List<FormResponse> getForm(char type){
        //分为两个部分
        //获取title标题
        //获取main主体

        List<FormResponse> formResponses;
        formResponses = formUtils.getNullForm(type);
        return formResponses;
    }
}
