package com.cyc.formmanager.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Project : FormManager - TableDao
 * Powered by GeorgeChen On 2024-11-20 13:48:47
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Mapper
public interface TableDao {

    int checkTable(String table);
}
