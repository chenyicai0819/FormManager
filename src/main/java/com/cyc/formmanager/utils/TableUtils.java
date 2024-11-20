package com.cyc.formmanager.utils;

import com.cyc.formmanager.controller.view.request.tables.ColumnRequest;
import com.cyc.formmanager.controller.view.response.tables.ColumnResponse;
import com.cyc.formmanager.controller.view.response.tables.TableResponse;
import com.cyc.formmanager.entity.enums.TableUpdateEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Project : FormManager - TableUtils
 * Powered by GeorgeChen On 2024-11-20 13:48:06
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Component
public class TableUtils {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    public int checkTable(String database, String tableName) {
        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS " +
                    "WHERE TABLE_NAME = ?";
            ResultSet rs = dbMetaData.getTables(null, null, tableName,null);
            if (!rs.next()){
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int checkColumn(String database, String tableName, String columnName) {
        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbMetaData = conn.getMetaData();
            // 查询表中是否存在该字段
            String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS " +
                    "WHERE TABLE_NAME = ? AND COLUMN_NAME = ?";
            ResultSet rs = dbMetaData.getColumns(null, null, tableName,columnName);
            if (!rs.next()){
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int createTable(String database, String tableName) {
        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "CREATE TABLE "+tableName+" (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute(sql);
            if (!result){
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int addColumn(String database, String tableName, String columnName,
                         String columnType, String columnRemark, boolean canNull) {
        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "ALTER TABLE " + tableName +
                    "ADD COLUMN " + columnName + " " +
                    columnType + " " + (canNull ? "NULL" : "NOT NULL") + "" +
                    "COMMENT " + columnRemark + ";"
                    ;
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute(sql);
            if (!result){
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int dropColumn(String database, String tableName, String columnName) {
        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "ALTER TABLE " + tableName +
                    "DROP COLUMN " + columnName + ";"
                    ;
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute(sql);
            if (!result){
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public TableResponse getColumn(String database, String tableName) {
        TableResponse tableResponse = new TableResponse();
        List<ColumnResponse> columnResponseList = new ArrayList<>();

        try {
            Class.forName(driverClassName);
            Connection conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getColumns(null, null, tableName,null);
            while (rs.next()) {
                ColumnResponse columnResponse = new ColumnResponse();
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("TYPE_NAME");
                int dataSize = rs.getInt("COLUMN_SIZE");
                String isNullable = rs.getString("IS_NULLABLE");
                String columnDef = rs.getString("COLUMN_DEF");
                String remarks = rs.getString("REMARKS");

                columnResponse.setColumnName(columnName);
                columnResponse.setColumnType(columnType);
                columnResponse.setColumnDef(columnDef);
                columnResponse.setColumnRemark(remarks);
                columnResponse.setCanNull(Objects.equals(isNullable, "YES"));
                columnResponse.setDataSize(dataSize);
                columnResponseList.add(columnResponse);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tableResponse.setTableName(tableName);
        tableResponse.setColumns(columnResponseList);
        return tableResponse;
    }

    public List<ColumnResponse> compare(String database, String tableName, List<ColumnRequest> columns, String updateType) {
        List<ColumnResponse> difference = new ArrayList<>();
        List<ColumnResponse> columnResponseList = getColumn(database,tableName).getColumns();
        List<String> olds = columnResponseList.stream()
                .map(ColumnResponse::getColumnName)
                .collect(Collectors.toList());
        List<String> news = columns.stream()
                .map(ColumnRequest::getColumnName)
                .collect(Collectors.toList());

        if (updateType.equals(TableUpdateEnum.ADD.getCode())){
            for (String item : news) {
                if (!olds.contains(item)) {
                    for (ColumnRequest column : columns) {
                        if (column.getColumnName().equals(item)) {
                            ColumnResponse response = new ColumnResponse();
                            MyBeanUtils.copy(response, column);
                            difference.add(response);
                            break;
                        }
                    }
                }
            }
        } else {
            for (String item : olds) {
                if (!news.contains(item)) {
                    for (ColumnResponse column : columnResponseList) {
                        if (column.getColumnName().equals(item)) {
                            difference.add(column);
                            break;
                        }
                    }
                }
            }
        }
        return difference;
    }
}
