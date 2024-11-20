package com.cyc.formmanager.utils;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Project : registration-project - MyBeanUtils
 * Powered by GeorgeChen On 2024-01-10 11:28:21
 *
 * @author GeorgeChen
 * @version 1.0
 * @since 1.8
 **/
public class MyBeanUtils {

    // static {
    //     //注册时间转换器 使得BeanUtils可以将date转换成指定格式String
    //
    // }

    public static void copy(Object dest,Object source){
        // ConvertUtils.register(new DateConverter(),Date.class);
        try {
            if (source != null){
                BeanUtils.copyProperties(dest,source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
