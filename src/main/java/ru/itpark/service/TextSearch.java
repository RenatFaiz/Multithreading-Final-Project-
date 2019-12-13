package ru.itpark.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSearch {

    public void parseFile(Path path, String searchString) throws IOException {
//        int wordsCounter = 0;
//        Scanner scan = new Scanner(path);
// //       scan.useDelimiter("(?m:^$)");
//        System.out.printf("[%s]:\n",path.getFileName());
//
//        while (scan.hasNext()) {
//            String line = scan.nextLine();
// //           System.out.printf("%3d) %s%n", wordsCounter, line);
//           // if (line.contains(searchString)) {
//            if(line.equalsIgnoreCase(searchString)) {
//                System.out.println(line);
//                wordsCounter++;
//            }
//        }
//         System.out.println("Number of matches: " + wordsCounter);
//    }
//
//    public void parseFilePattern(String text, String searchString) {
//        Pattern pattern = Pattern.compile(searchString);
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
   }
}
