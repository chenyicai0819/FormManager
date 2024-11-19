package com.cyc.formmanager.dao;

import com.cyc.formmanager.entity.form.FormFillBlankDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project : FormManager - TFormFillBlankDao
 * Powered by GeorgeChen On 2024-11-20 00:55:20
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Mapper
public interface TFormFillBlankDao {

    int deleteByPrimaryKey(String code);

    int insert(FormFillBlankDO record);

    int insertSelective(FormFillBlankDO record);

    FormFillBlankDO selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(FormFillBlankDO record);

    int updateByPrimaryKey(FormFillBlankDO record);
}
