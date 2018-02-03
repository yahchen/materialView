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
        String fn = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMC-PROC-20171029-210126.BIN";
        String[] fnt = fn.split("\\.|-");
        System.out.println(fnt[fnt.length-2]);
        for(String f:fnt){
            System.out.println(f);
        }
    }
}
