package ru.itpark.service;

import ru.itpark.servlet.Servlet;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileVisitor extends SimpleFileVisitor<Path> {


    private String searchString;
    private List<String> result = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Scanner scan = new Scanner(file);
        int wordsCounter = 0;

        // scan.useDelimiter("(?m:^$)");
        System.out.printf("[%s]:\n", file.getFileName());
        result.add(file.getFileName().toString());

        while (scan.hasNext()) {
            String line = scan.nextLine();
            // System.out.printf("%3d) %s%n", wordsCounter, line);
            if (line.contains(searchString)) {
              //  result.add(line);
                System.out.println(line);
                wordsCounter++;
            }
        }
        System.out.println("Number of matches: " + wordsCounter + "\n");
        result.add("Number of matches: " + wordsCounter + "\n");
        return FileVisitResult.CONTINUE;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<String> getResult() {
        return result;
    }
}
