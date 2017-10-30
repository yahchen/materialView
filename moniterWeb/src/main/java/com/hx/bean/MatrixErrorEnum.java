package com.hx.bean;

import org.thymeleaf.util.StringUtils;

/**
 * Created by hp on 2017/10/30.
 */
public enum MatrixErrorEnum {

    SUCCESS("0","Call Succeed."),
    NORECORD("-1","No data is retrieved. detail: Query Success,but no record is in database.");

    private String code;
    private String desc;

    MatrixErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getErrorEnumByCode(String code){
        for(MatrixErrorEnum errorEnum : MatrixErrorEnum.values()){
            if(StringUtils.equals(code, errorEnum.getCode())){
                return errorEnum.getDesc();
            }
        }
        return "无此类型的错误";
    }
}
