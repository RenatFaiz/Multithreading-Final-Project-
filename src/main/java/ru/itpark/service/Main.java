package ru.itpark.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        TextSearch fileSearch = new TextSearch();
        final FileService fileService = new FileService();


        //String path = "Destination/rfc1945.txt";
        //String path = "Destination/test.txt";
        Path path  = Paths.get("Destination/");
        String searchString = "am";

        Files.walkFileTree(path, new FileVisitor());
       // fileSearch.parseFile(path, searchString);
       // fileSearch.parseFilePattern("Am am amama", "am");

        //fileService.getAll();
    }
}
