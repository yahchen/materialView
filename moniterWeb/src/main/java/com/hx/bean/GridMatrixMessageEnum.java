package com.hx.bean;

import org.thymeleaf.util.StringUtils;

/**
 * Created by hp on 2017/10/30.
 */
public enum GridMatrixMessageEnum {
    ECWD("TM_GRID_ECMWF_T","欧洲中心格点场资料-温度要素"),
    ECWSGD("TM_GRID_ECMWF_H","欧洲中心格点场资料-位势高度要素"),
    ECUF("TM_GRID_ECMWF_U","欧洲中心格点场资料-u风要素"),
    ECVF("TM_GRID_ECMWF_V","欧洲中心格点场资料-v风要素"),
    JPJS("TM_GRID_JAPAN_PRE","日本格点场降水资料-降水要素"),
    JPWD("TM_GRID_JAPAN_T","日本格点场降水资料-温度要素"),
    JPWSGD("TM_GRID_JAPAN_H","日本格点场降水资料-位势高度要素"),
    JPUF("TM_GRID_JAPAN_U","日本格点场降水资料-u风要素"),
    JPVF("TM_GRID_JAPAN_V","日本格点场降水资料-v风要素");

    private String code;
    private String desc;

    GridMatrixMessageEnum(String code, String desc) {
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

    public static String getMatricMessageByCode(String code){
        for(GridMatrixMessageEnum matrixEnum : GridMatrixMessageEnum.values()){
            if(StringUtils.equals(code, matrixEnum.getCode())){
                return matrixEnum.getDesc();
            }
        }
        return "";
    }
}
