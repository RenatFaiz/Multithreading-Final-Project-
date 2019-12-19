package ru.itpark.service;

import ru.itpark.servlet.Servlet;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileVisitor2 extends SimpleFileVisitor<Path> {


    private String searchString;
    private Servlet servlet;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String resultsPath = file.getParent().getParent().toString() + "/result/results.txt";

//        String resultFile = file.toString().replace("upload", "result/results.txt");
        // Files.createDirectories()
// "D:/Coding/Destination/result.txt"
        // System.out.println(servlet.getFullResultDirectory());
        System.out.println(file);
        System.out.println(resultsPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter((resultsPath), true));
             BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {


            writer.write(file.getFileName().toString() + ": ");
            int stringsCounter = 0;
            String s;
            while ((s = reader.readLine()) != null) {
                if (s.contains(searchString)) {
                    writer.write(s.strip() + "\n");
                    stringsCounter++;
                }
            }

            writer.write("Number of matches: " + stringsCounter + "\n\n");
        }
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }


    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }


    // public int getWordsCounter() {
//        return wordsCounter;
//    }
}

//    Pattern pattern = Pattern.compile(searchString);
//            Matcher matcher = pattern.matcher(reader.);
//           // boolean isFound = matcher.matches();
//            while (matcher.find()) {
//                result.add(matcher.group());
//                wordsCounter++;
//            }