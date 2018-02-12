package com.hx.monitor;

import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

enum SexEnum {
    MAN("M", "男"),
    WOMAN("F", "女");

    private String code;
    private String desc;

    SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getSexEnumByCode(String code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (StringUtils.equals(code, sexEnum.getCode())) {
                return sexEnum.getDesc();
            }
        }
        return null;
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

/**
 * Created by hp on 2017/10/30.
 */
public class TestMain {

    public static void main(String[] args) {
        //System.out.println(SexEnum.getSexEnumByCode("M"));
        Timestamp start = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        String s = "1987年08月32日 33时";
        System.out.println(sdf.format(start));
        System.out.println(SexEnum.getSexEnumByCode("M"));
    }
}

