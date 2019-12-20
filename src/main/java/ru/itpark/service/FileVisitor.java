package ru.itpark.service;


import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitor extends SimpleFileVisitor<Path> {


    private String searchString;
    private int matchesCounter;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String resultsPath = file.getParent().getParent().toString() + "\\result\\results.txt";

// String resultFile = file.toString().replace("upload", "result/results.txt");

        System.out.println("Визитор: файл для поиска " + file);
        System.out.println("Визитор: файл с результатами " + resultsPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter((resultsPath), true));
             BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {


            writer.write(file.getFileName().toString() + ": ");
            int stringsCounter = 0;
            String s;
            while ((s = reader.readLine()) != null) {
                if (s.contains(searchString)) {
                    writer.write(s.trim() + "\n");
                    stringsCounter++;
                }
            }
            matchesCounter += stringsCounter;

            writer.write("Number of matches: " + stringsCounter + "\n\n");
        }
        Files.deleteIfExists(file);
        return FileVisitResult.CONTINUE;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getMatchesCounter() {
        return matchesCounter;
    }
}
