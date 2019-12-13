package ru.itpark.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextSearch {
    public void parseFile(String fileName, String searchString) throws FileNotFoundException {
        int wordsCounter = 0;
        Scanner scan = new Scanner(new File(fileName));
 //       scan.useDelimiter("(?m:^$)");
        while (scan.hasNext()) {
            String line = scan.nextLine();

 //           System.out.printf("%3d) %s%n", wordsCounter, line);
            if (line.contains(searchString)) {
                System.out.println(line);
                wordsCounter++;
            }
        }
         System.out.println("Number of matches: " + wordsCounter);
    }
}
