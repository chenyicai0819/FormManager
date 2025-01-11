package com.cyc.formmanager.service.impl;

import com.cyc.formmanager.controller.view.request.form.FormChildrenRequest;
import com.cyc.formmanager.controller.view.request.form.FormMainRequest;
import com.cyc.formmanager.controller.view.request.tables.ColumnRequest;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.dao.TFormFillBlankDao;
import com.cyc.formmanager.dao.TFormMainDao;
import com.cyc.formmanager.dao.TFormSelectDao;
import com.cyc.formmanager.entity.enums.FormTypeEnum;
import com.cyc.formmanager.entity.form.FormFillBlankDO;
import com.cyc.formmanager.entity.form.FormMainDO;
import com.cyc.formmanager.entity.form.FormSelectDO;
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

    @Autowired
    private TFormMainDao formMainDao;
    @Autowired
    private TFormFillBlankDao formFillBlankDao;
    @Autowired
    private TFormSelectDao formSelectDao;

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
        List<FormMainDO> formMainDOList = new ArrayList<>();
        List<FormSelectDO> selectDOList = new ArrayList<>();
        List<FormFillBlankDO> fillBlankDOList = new ArrayList<>();

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

            FormMainDO formMainDO = formChildrenRequest.covertFormMainDO();
            formMainDO.setTableName(request.getTableName());
            formMainDO.setDatabaseName(request.getDatabase());
            formMainDOList.add(formMainDO);

            selectDOList = formChildrenRequest.covertFormSelectDOList();
            fillBlankDOList = formChildrenRequest.covertFormFillBlankDOList();
        }
        // 将表单信息进行存储
        int formResult = formMainDao.insertList(formMainDOList);
        if (formResult != 0) {
            // 存储表单规则
            for (FormMainDO formMainDO : formMainDOList) {
                if ("QuestionOption".equals(FormTypeEnum.getType(formMainDO.getType()))) {
                    formSelectDao.insertList(selectDOList);
                } else if ("FillBlankAttribute".equals(FormTypeEnum.getType(formMainDO.getType()))) {
                    formFillBlankDao.insertList(fillBlankDOList);
                }
            }
        }
        // 创建对应的表字段
        int tableResult = 0;
        if (formResult != 0) {
            tableResult = tableService.addColumn(request.getDatabase(),
                    request.getTableName(),
                    columnRequests);
        }
        return tableResult;
    }

    @Override
    public int dropForm(List<String> code) {
        // 根绝code查询出表单的信息
        List<FormMainDO> formMainDOList = formMainDao.selectListByPrimaryKey(code);
        List<ColumnRequest> columns = new ArrayList<>();

        for (FormMainDO formMainDO : formMainDOList) {
            ColumnRequest columnRequest = new ColumnRequest();
            columnRequest.setColumnName(formMainDO.getUserDefineCode());
            columns.add(columnRequest);
        }
        int tableResult = tableService.dropColumn(formMainDOList.get(0).getDatabaseName(),
                formMainDOList.get(0).getTableName(),
                columns);
        int formResult = 0;
        if (tableResult != 0) {
            for (String s : code) {
                int result = formMainDao.deleteByPrimaryKey(s);
                formResult += result;
            }
        }
        if (formResult != 0) {
            for (FormMainDO formMainDO : formMainDOList) {
                if ("QuestionOption".equals(FormTypeEnum.getType(formMainDO.getType()))) {
                    formSelectDao.deleteByPrimaryKey(formMainDO.getCode());
                } else if ("FillBlankAttribute".equals(FormTypeEnum.getType(formMainDO.getType()))) {
                    formFillBlankDao.deleteByPrimaryKey(formMainDO.getCode());
                }
            }
        }
        return formResult;
    }
}
