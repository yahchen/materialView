package com.hx.syncer.fileHandler;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahchen on 2018/1/12.
 */
public class SateDataFileVistor extends SimpleFileVisitor<Path> {
    private List<Path> result;
    private List<String> filterFileNameList = new ArrayList<>();
    public SateDataFileVistor(List<Path> result,List<String> filterFnList){
        this.result = result;
        this.filterFileNameList.addAll(filterFnList);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        String fileName = file.getFileName().toString().toLowerCase();
        if(fileName.endsWith(".bin")){
            filterFileNameList.forEach(fn->{
                if(fn.contains(fileName)) {
                    result.add(file);
                }
            });
        }
        return FileVisitResult.CONTINUE;
    }
}
