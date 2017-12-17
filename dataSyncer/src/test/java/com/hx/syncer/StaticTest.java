package com.hx.syncer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/7.
 */
public class StaticTest {
    private static SimpleDateFormat ss = new SimpleDateFormat("yyyyMMddHHmm");
    public static void main(String[] args) throws Exception{
        String s = "201711091100";
        System.out.println(Timestamp.valueOf(ss.parse(s).toLocaleString()));
        String sss = "sdfs:sdfs:sdfsd:sddfs";
        System.out.println(sss.split(":",2)[1]);
    }
}
