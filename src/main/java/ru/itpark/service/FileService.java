package ru.itpark.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    Path path = Paths.get("Destination/test.txt");
    List<String> sourceText = Files.readAllLines(path);

    public void getAll() {
        for(String s : sourceText) {
            System.out.println(s);
        }
    }
    public FileService() throws IOException {
    }
}
