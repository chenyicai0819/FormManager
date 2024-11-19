package com.cyc.formmanager.dao;

import com.cyc.formmanager.entity.form.FormMainDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project : FormManager - TFormMainDao
 * Powered by GeorgeChen On 2024-11-20 00:54:02
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Mapper
public interface TFormMainDao {

    int deleteByPrimaryKey(String code);

    int insert(FormMainDO record);

    int insertSelective(FormMainDO record);

    FormMainDO selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(FormMainDO record);

    int updateByPrimaryKey(FormMainDO record);
}
