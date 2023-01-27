package com.goit.feature.downloader;

import com.goit.feature.HttpStatusChecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    private static final String STORAGE_PATH = "src/main/resources/images/";

    public void downloadStatusImage(int code) throws IOException, InterruptedException {
        HttpStatusChecker checker = new HttpStatusChecker();

        String imageUrl = checker.getStatusImage(code);
        String fileName = code + ".jpg";
        File file = new File(STORAGE_PATH + fileName);

        if (file.exists()) {
            throw new FileAlreadyExistsException("File already exists!");
        }

        try(InputStream in = new URL(imageUrl).openStream()) {
            Files.copy(in, Paths.get(String.valueOf(file)));
        }
    }
}
