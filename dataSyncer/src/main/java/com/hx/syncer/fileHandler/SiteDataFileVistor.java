package com.hx.syncer.fileHandler;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/4.
 */

public class SiteDataFileVistor extends SimpleFileVisitor<Path> {
    private List<Path> result;
    private Pattern pattern;
    public SiteDataFileVistor(List<Path> result, Pattern p){
        this.result = result;
        this.pattern = p;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        String fileName = file.getFileName().toString();
        if(fileName.endsWith(".json") && pattern.matcher(fileName.toLowerCase()).find()){
            result.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
