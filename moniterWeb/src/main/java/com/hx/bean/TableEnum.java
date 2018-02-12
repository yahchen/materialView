package com.hx.bean;

import org.thymeleaf.util.StringUtils;

/**
 * Created by hp on 2017/10/30.
 */
public enum TableEnum {
    SDH("1", "site_data_head"),
    GDH("2", "grid_data_head"),
    FDH("3", "file_data_head"),
    SFDH("4", "satellite_file_data_head");

    private String code;
    private String desc;

    TableEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getTableByCode(String code) {
        for (TableEnum tableEnum : TableEnum.values()) {
            if (StringUtils.equals(code, tableEnum.getCode())) {
                return tableEnum.getDesc();
            }
        }
        return "";
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
}
