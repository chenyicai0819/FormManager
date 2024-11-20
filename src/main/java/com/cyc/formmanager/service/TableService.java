package com.cyc.formmanager.service;

import com.cyc.formmanager.controller.view.response.tables.TableResponse;

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
}
