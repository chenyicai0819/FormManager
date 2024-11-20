package com.cyc.formmanager.controller.view.request.tables;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Project : FormManager - compareColumnRequest
 * Powered by GeorgeChen On 2024-11-21 01:07:26
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class CompareColumnRequest {

    @ApiModelProperty(value = "数据库")
    private String database;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "字段列表")
    private List<ColumnRequest> columns;

    @ApiModelProperty(value = "新增：add、删除：drop")
    private String updateType;
}
