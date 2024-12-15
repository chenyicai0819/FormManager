package com.cyc.formmanager.controller.view.request.tables;

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
public class ColumnRequest {

    private String columnName;

    private String columnType;

    private String columnRemark;

    private Boolean canNull;

    private String columnDef;

    private int dataSize;
}
