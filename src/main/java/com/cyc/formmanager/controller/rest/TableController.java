package com.cyc.formmanager.controller.rest;

import com.cyc.formmanager.controller.view.request.tables.CompareColumnRequest;
import com.cyc.formmanager.controller.view.response.form.FormResponse;
import com.cyc.formmanager.controller.view.response.tables.ColumnResponse;
import com.cyc.formmanager.controller.view.response.tables.TableResponse;
import com.cyc.formmanager.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project : FormManager - TableController
 * Powered by GeorgeChen On 2024-11-21 00:30:03
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Api(value="caseController", tags={"数据库表控制层"})
@RequestMapping("table")
@RestController
@Slf4j
public class TableController {

    @Autowired
    private TableService tableService;

    @ApiOperation(value = "获取数据库表字段")
    @GetMapping(value = "getColumn")
    public TableResponse getColumn(String tableName){
        return tableService.getColumn(tableName);
    }

    @ApiOperation(value = "对比数据库表字段")
    @PostMapping(value = "compareColumn")
    public List<ColumnResponse> compareColumn(@RequestBody CompareColumnRequest request){
        return tableService.compareColumn(request.getDatabase(),
                request.getTableName(),
                request.getColumns(),
                request.getUpdateType());
    }
}
