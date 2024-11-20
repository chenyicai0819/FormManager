package com.cyc.formmanager.controller.view.response.tables;

import lombok.Data;

/**
 * Project : FormManager - ColumnResponse
 * Powered by GeorgeChen On 2024-11-20 14:39:05
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class ColumnResponse {

    private String columnName;

    private String columnType;

    private String columnRemark;

    private boolean canNull;

    private String columnDef;

    private int dataSize;
}
