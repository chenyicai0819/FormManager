package com.cyc.formmanager.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Project : FormManager - TableUpdateEnum
 * Powered by GeorgeChen On 2024-11-21 00:51:01
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@AllArgsConstructor
@Getter
public enum TableUpdateEnum {

    ADD("add","新增字段"),
    DROP("drop","删除字段")
    ;

    private String code;
    private String message;
}
