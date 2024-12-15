package com.cyc.formmanager.controller.rest;

import com.cyc.formmanager.controller.view.request.form.FormMainRequest;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.service.FormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project : FormManager - FormController
 * Powered by GeorgeChen On 2024-11-20 00:11:32
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Api(value="caseController", tags={"表单控制层"})
@RequestMapping("form")
@RestController
@Slf4j
public class FormController {

    @Autowired
    private FormService formService;

    @ApiOperation(value = "获取form转为json")
    @GetMapping(value = "getForm")
    public List<FormResponse> getForm(char type) {
        return formService.getForm(type);
    }

    @ApiOperation(value = "新增表单")
    @PostMapping(value = "addForm")
    public void addForm(@RequestBody FormMainRequest request) {
        formService.addForm(request);
    }
}
