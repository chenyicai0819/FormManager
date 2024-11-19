package com.cyc.formmanager.utils;

import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.dao.*;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.*;

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
        List<FormResponse> formResponses = new ArrayList<>();
        String redisKey = "key";
        Object o = RedisUtils.get(redisKey);
        return formResponses;
    }
}
