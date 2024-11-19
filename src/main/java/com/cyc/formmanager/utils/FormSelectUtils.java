package com.cyc.formmanager.utils;

import com.cyc.formmanager.dao.TFormSelectDao;
import com.cyc.formmanager.entity.form.FormSelectDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project : FormManager - FormSelectUtils
 * Powered by GeorgeChen On 2024-11-20 01:14:48
 * 选择题-工具类
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Component
public class FormSelectUtils {
    @Resource
    private TFormSelectDao selectDao;

    /**
     * 获取一个选择题答案详情
     * @return FormSelectDO
     */
    public FormSelectDO one(int id, String code, String userDefineCode) {
        return selectDao.one(id, code, userDefineCode);
    }


}
