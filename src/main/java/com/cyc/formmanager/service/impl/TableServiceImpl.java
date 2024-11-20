package com.cyc.formmanager.service.impl;

import com.cyc.formmanager.controller.view.response.tables.TableResponse;
import com.cyc.formmanager.service.TableService;
import com.cyc.formmanager.utils.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project : FormManager - TableServiceImpl
 * Powered by GeorgeChen On 2024-11-21 00:31:59
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Service
@Slf4j
public class TableServiceImpl implements TableService {
    @Autowired
    private TableUtils tableUtils;

    @Override
    public TableResponse getColumn(String tableName) {
        return tableUtils.getColumn(null, tableName);
    }
}
