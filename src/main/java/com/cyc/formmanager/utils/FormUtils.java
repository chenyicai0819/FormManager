package com.cyc.formmanager.utils;

import com.cyc.formmanager.controller.view.response.form.FormChildrenResponse;
import com.cyc.formmanager.controller.view.response.form.FormMainResponse;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.dao.*;
import com.cyc.formmanager.entity.QuestionOption;
import com.cyc.formmanager.entity.enums.FormTypeEnum;
import com.cyc.formmanager.entity.form.FormSelectDO;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Project : registration-project - FormUtils
 * Powered by GeorgeChen On2023-09-16 14:59:38
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Component
public class FormUtils {

    static {
        //注册时间转换器 使得BeanUtils可以将date转换成指定格式String
        ConvertUtils.register(new DateConverter(),String.class);
    }

    @Resource
    private TFormMainDao formMainDao;
    @Resource
    private TFormModuleDao formModuleDao;
    @Resource
    private TFormIndexDao formIndexDao;
    @Resource
    private TFormSelectDao formSelectDao;
    @Resource
    private TFormFillBlankDao formFillBlankDao;

    @Autowired
    private FormSelectUtils selectUtils;

    public List<FormResponse> getNullForm(char type){
        List<FormResponse> formResponses;
        formResponses = formMainDao.getTitle(type);
        for (int i = 0; i < formResponses.size(); i++) {
            FormResponse formResponse = new FormResponse();
            List<FormChildrenResponse> childrenResponseList  = new ArrayList<>();
            List<FormChildrenResponse> formChildrenRespons = formMainDao.getMainByTitle(formResponses.get(i).getTitle(),type);
            childrenResponseList = handleFormChildren(formChildrenRespons);
            formResponse.setTitle(formResponses.get(i).getTitle());
            List<FormMainResponse> mainResponseList = new ArrayList<>();
            FormMainResponse mainResponse = new FormMainResponse();
            mainResponse.setChildren(childrenResponseList);
            // mainResponse.setIsConfig(isConfig);
            mainResponseList.add(mainResponse);
            formResponse.setMain(mainResponseList);
            formResponse.setModuleTab(formResponses.get(i).getModuleTab());
            formResponses.set(i,formResponse);
        }

        return formResponses;
    }

    public List<FormChildrenResponse> handleFormChildren(List<FormChildrenResponse> formChildrenRespons) {
        List<FormChildrenResponse> out  = new ArrayList<>();
        for (int j = 0; j < formChildrenRespons.size(); j++) {
            FormChildrenResponse formChildrenResponse = new FormChildrenResponse();
            //根据问题类型获取配置
            if (formChildrenRespons.get(j).getType().equals(FormTypeEnum.RADIO.getCode())){
                //单选
                formChildrenResponse.setOptions(selectUtils.doToEntityList(formSelectDao.listByUserDefineCode(formChildrenRespons.get(j).getQuestionId())));
                formChildrenResponse.setFillBlanks(new ArrayList<>());
            }else if (formChildrenRespons.get(j).getType().equals(FormTypeEnum.COMBO_BOX.getCode())){
                //下拉框
                formChildrenResponse.setOptions(selectUtils.doToEntityList(formSelectDao.listByUserDefineCode(formChildrenRespons.get(j).getQuestionId())));
                formChildrenResponse.setFillBlanks(new ArrayList<>());
            }else if (formChildrenRespons.get(j).getType().equals(FormTypeEnum.CHECK_BOX.getCode())){
                //多选
                formChildrenResponse.setOptions(selectUtils.doToEntityList(formSelectDao.listByUserDefineCode(formChildrenRespons.get(j).getQuestionId())));
                formChildrenResponse.setFillBlanks(new ArrayList<>());
            }

            formChildrenResponse.setCode(formChildrenRespons.get(j).getCode());
            formChildrenResponse.setLabel(formChildrenRespons.get(j).getLabel());
            formChildrenResponse.setRequired(formChildrenRespons.get(j).getRequired());
            formChildrenResponse.setType(formChildrenRespons.get(j).getType());
            formChildrenResponse.setUserdefinecode(formChildrenRespons.get(j).getUserdefinecode());
            formChildrenResponse.setQuestionId(formChildrenRespons.get(j).getQuestionId());
            formChildrenResponse.setTitle(formChildrenRespons.get(j).getTitle());
            formChildrenResponse.setValueList(new ArrayList<>());
            formChildrenResponse.setValue(null);
            formChildrenResponse.setMultiple(formChildrenRespons.get(j).getMultiple());
            out.add(formChildrenResponse);
        }
        return out;
    }


}
