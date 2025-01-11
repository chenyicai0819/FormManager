package com.cyc.formmanager.dao;

import com.cyc.formmanager.entity.form.FormSelectDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Project : FormManager - TFormSelectDao
 * Powered by GeorgeChen On 2024-11-20 00:54:57
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Mapper
public interface TFormSelectDao {

    int deleteByPrimaryKey(String code);

    int insert(FormSelectDO record);

    int insertList(List<FormSelectDO> list);

    int insertSelective(FormSelectDO record);

    FormSelectDO selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(FormSelectDO record);

    int updateByPrimaryKey(FormSelectDO record);

    FormSelectDO one(int id, String code, String userDefineCode);

    List<FormSelectDO> listByUserDefineCode(String userDefineCode);
}
