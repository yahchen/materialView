package com.hx.syncer;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/7.
 */
public class StaticTest {
    public static void main(String[] args) throws Exception{
        String st = "20171029210253;20171029210126;20171029222534;20171029210350;20171029210124;20171029220252;20171029210351;20171029212300;20171029212300;20171029211600;20171029000000;20171029211100;20171029210119;20171030011415;20171029211100;20171201014611";
        String[] tt = st.split(";");
        for(String t:tt){
            Date date = DateUtils.parseDate(t, "");
            Timestamp ts = Timestamp.valueOf(date.toString());
            System.out.println(ts.toString());
        }
    }
}
