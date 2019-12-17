package ru.itpark.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

//        Path path  = Paths.get("Destination/");
//        String searchString = "am";
//
//        final FileVisitor visitor = new FileVisitor();
//        visitor.setSearchString("HTTP");
//
//        Files.walkFileTree(path, visitor);
//        System.out.println(visitor.getResult());

        Path path2 = Paths.get("Destination/test.txt");
        final FileVisitor2 visitor2 = new FileVisitor2();
        visitor2.setSearchString("am");
        Files.walkFileTree(path2, visitor2);

       // fileSearch.parseFile(path, searchString);
       // fileSearch.parseFilePattern("Am am amama", "am");

        //fileService.getAll();
    }
}
