package com.hx.syncer;

import java.sql.Timestamp;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/7.
 */
public class StaticTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\{|\\}");
        boolean res = p.matcher("sdsdf}").find();
        System.out.println(res);
        System.out.println(Timestamp.valueOf("2017-10-13 14:16:28").getTime());
    }
}
