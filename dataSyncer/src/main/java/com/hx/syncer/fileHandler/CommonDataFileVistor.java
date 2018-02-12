package com.hx.syncer.fileHandler;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */

public class CommonDataFileVistor extends SimpleFileVisitor<Path> {
    private List<Path> result;

    public CommonDataFileVistor(List<Path> result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fileName = file.getFileName().toString().toLowerCase();
        if (fileName.endsWith(".json")) {
            result.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
