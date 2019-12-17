package ru.itpark.service;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileVisitor2 extends SimpleFileVisitor<Path> {


    private String searchString;
    private List<String> result = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        int wordsCounter = 0;
        try (FileWriter writer = new FileWriter("result.txt", false);
             BufferedReader reader = new BufferedReader (new FileReader(file.toString()))) {


            String s;
            while ((s = reader.readLine()) != null) {
                if(s.contains(searchString)) {
                    writer.write(s + "\n");
                }
            }
//

            //writer.write();
            //System.out.println(wordsCounter);
        }


        return FileVisitResult.CONTINUE;
    }


    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<String> getResult() {
        return result;
    }
}

//    Pattern pattern = Pattern.compile(searchString);
//            Matcher matcher = pattern.matcher(reader.);
//           // boolean isFound = matcher.matches();
//            while (matcher.find()) {
//                result.add(matcher.group());
//                wordsCounter++;
//            }