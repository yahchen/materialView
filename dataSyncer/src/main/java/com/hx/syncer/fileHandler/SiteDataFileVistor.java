package com.hx.syncer.fileHandler;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */

public class SiteDataFileVistor extends SimpleFileVisitor<Path> {
    private List<Path> result;
    public SiteDataFileVistor(List<Path> result){
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        String fileName = file.getFileName().toString();
        if(fileName.endsWith(".json")){
            try {
                System.out.println("sdfsdf");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            result.add(file);
        } return FileVisitResult.CONTINUE;
    }
}
