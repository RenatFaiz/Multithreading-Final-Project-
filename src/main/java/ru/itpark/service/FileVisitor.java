package ru.itpark.service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

public class FileVisitor extends SimpleFileVisitor<Path> {

    String searchString = "HTTP";

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // List<String> sourceText = Files.readAllLines(file);

        Scanner scan = new Scanner(file);
        int wordsCounter = 0;

        // scan.useDelimiter("(?m:^$)");
        System.out.printf("[%s]:\n", file.getFileName());

        while (scan.hasNext()) {
            String line = scan.nextLine();
            // System.out.printf("%3d) %s%n", wordsCounter, line);
            if (line.contains(searchString)) {
                System.out.println(line);
                wordsCounter++;
            }
        }
        System.out.println("Number of matches: " + wordsCounter + "\n");

        return FileVisitResult.CONTINUE;
    }
}
