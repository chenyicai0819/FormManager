package com.cyc.formmanager.service.impl;

import com.cyc.formmanager.controller.view.request.form.FormChildrenRequest;
import com.cyc.formmanager.controller.view.request.form.FormMainRequest;
import com.cyc.formmanager.controller.view.request.tables.ColumnRequest;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.service.FormService;
import com.cyc.formmanager.service.TableService;
import com.cyc.formmanager.utils.FormUtils;
import com.cyc.formmanager.utils.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TableService tableService;

    @Override
    public List<FormResponse> getForm(char type){
        //分为两个部分
        //获取title标题
        //获取main主体

        List<FormResponse> formResponses;
        formResponses = formUtils.getNullForm(type);
        return formResponses;
    }

    @Override
    public int addForm(FormMainRequest request) {
        // 将表单中内容转换为数据库表的内容
        List<ColumnRequest> columnRequests = new ArrayList<>();
        List<FormChildrenRequest> formChildrenRequests = request.getChildren();

        for (FormChildrenRequest formChildrenRequest : formChildrenRequests) {
            ColumnRequest columnRequest = new ColumnRequest();
            columnRequest.setColumnName(formChildrenRequest.getUserdefinecode());
            columnRequest.setColumnRemark(formChildrenRequest.getLabel());
            columnRequest.setCanNull(!formChildrenRequest.getRequired());
            if (formChildrenRequest.getFillBlanks() != null) {
                // 填空题
                columnRequest.setDataSize(Integer.parseInt(formChildrenRequest.getFillBlanks().get(0).getMax()));
                columnRequest.setColumnType("varchar(" + columnRequest.getDataSize() + ")");
            } else {
                // 选择题
                columnRequest.setDataSize(11);
                columnRequest.setColumnType("varchar(11)");
            }
            columnRequests.add(columnRequest);
        }
        return tableService.addColumn(request.getDatabase(),
                request.getTableName(),
                columnRequests);
    }
}
