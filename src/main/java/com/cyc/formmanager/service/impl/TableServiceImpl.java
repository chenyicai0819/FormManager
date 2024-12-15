package com.cyc.formmanager.service.impl;

import ch.qos.logback.classic.db.names.ColumnName;
import com.cyc.formmanager.controller.view.request.tables.ColumnRequest;
import com.cyc.formmanager.controller.view.response.tables.ColumnResponse;
import com.cyc.formmanager.controller.view.response.tables.TableResponse;
import com.cyc.formmanager.service.TableService;
import com.cyc.formmanager.utils.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ColumnResponse> compareColumn(String database, String tableName, List<ColumnRequest> columns, String updateType) {
        return tableUtils.compare(database, tableName,columns,updateType);
    }

    @Override
    public int addColumn(String database, String tableName, List<ColumnRequest> columns) {
        int request = 0;
        for (ColumnRequest column : columns) {
            request  += tableUtils.addColumn(database,tableName,
                    column.getColumnName(),
                    column.getColumnType(),
                    column.getColumnRemark(),
                    column.getCanNull());
        }
        return request;
    }
}
