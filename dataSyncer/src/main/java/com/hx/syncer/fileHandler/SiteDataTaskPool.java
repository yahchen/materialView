package com.hx.syncer.fileHandler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class SiteDataTaskPool{
    @Async
    public void run(Path path) {
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            int i = 0;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
