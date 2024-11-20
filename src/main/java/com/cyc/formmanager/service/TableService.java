package com.cyc.formmanager.service;

import ch.qos.logback.classic.db.names.ColumnName;
import com.cyc.formmanager.controller.view.request.tables.ColumnRequest;
import com.cyc.formmanager.controller.view.response.tables.ColumnResponse;
import com.cyc.formmanager.controller.view.response.tables.TableResponse;

import java.util.List;

/**
 * Project : FormManager - TableService
 * Powered by GeorgeChen On 2024-11-21 00:31:33
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
public interface TableService {
    TableResponse getColumn(String tableName);

    List<ColumnResponse> compareColumn(String database, String tableName, List<ColumnRequest> columns, String updateType);
}
