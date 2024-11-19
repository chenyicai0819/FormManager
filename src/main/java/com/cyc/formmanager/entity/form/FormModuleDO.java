package com.cyc.formmanager.entity.form;

import lombok.Data;

/**
 * Project : registration-project - FormModuleDO
 * Powered by GeorgeChen On 2023-11-18 14:21:40
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
@Data
public class FormModuleDO {

    private Character caseType;
    private String title;
    private Integer moduleIndex;
    private String moduleName;
}
