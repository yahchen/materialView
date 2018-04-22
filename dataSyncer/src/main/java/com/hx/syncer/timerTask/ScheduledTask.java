package com.hx.syncer.timerTask;

import com.hx.syncer.fileHandler.CommonDataFileVistor;
import com.hx.syncer.fileHandler.CommonDataTaskPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
@Slf4j
public class ScheduledTask {

    @Value("${spring.inbound.path}")
    private String inBoundFilePath;

    @Autowired
    private CommonDataTaskPool commonDataTaskPool;

    //第一次延迟10秒执行，当执行完后1小时再执行
    @Scheduled(initialDelay = 5000, fixedDelay = 3600000)
    public void syncData() {
        try {
            //遍历文件夹下面的文件
            List<Path> result = new LinkedList<Path>();
            Files.walkFileTree(Paths.get(inBoundFilePath), new CommonDataFileVistor(result));
            for (Path path : result) {
                commonDataTaskPool.asyncSaveCommonDbData(path);
                try {
                    Thread.sleep(2000);//在处理一个站点（格点等）文件及其数据文件时，睡2s，避免过多文件加载到内存，oom
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            log.error("sync data error", e);
        }

    }

//    //每天20点16分50秒时执行
//    @Scheduled(cron = "50 16 20 * * ?")
//    public void timerCron() {
//        System.out.println("current time : "+ dateFormat.format(new Date()));
//    }
}
