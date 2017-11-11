package com.hx.syncer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/7.
 */
public class StaticTest {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("fin.txt"), StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            for (int i = 0; i < 50; i++) {
                double nb = Math.random() * (9999 - 20) + 20;
                bw.write(nb + "");
                bw.newLine();
            }
            BufferedReader br = Files.newBufferedReader(Paths.get("fin.txt"), StandardCharsets.UTF_8);
            TreeSet<Double> sortedSet = new TreeSet<>();
            String line = null;
            while ((line = br.readLine()) != null) {
                sortedSet.add(Double.valueOf(line));
            }
            BufferedWriter outBw = Files.newBufferedWriter(Paths.get("fout.txt"), StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            sortedSet.forEach(x -> {
                try {
                    outBw.write(x + "");
                    outBw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
