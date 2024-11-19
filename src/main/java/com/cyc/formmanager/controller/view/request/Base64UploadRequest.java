package com.cyc.formmanager.controller.view.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Base64UploadRequest {
    @ApiModelProperty("base64字符串")
    private String base64;
}
