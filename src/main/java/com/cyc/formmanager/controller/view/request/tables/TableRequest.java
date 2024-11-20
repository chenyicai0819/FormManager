package com.cyc.formmanager.controller.view.request.tables;

import com.cyc.formmanager.controller.view.response.tables.ColumnResponse;
import lombok.Data;

import java.util.List;

/**
 * Project : FormManager - TableResponse
 * Powered by GeorgeChen On 2024-11-20 14:40:52
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class TableRequest {

    private String tableName;

    private List<ColumnResponse> columns;
}
