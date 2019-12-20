package ru.itpark.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {


//
//        Files.walkFileTree(path, visitor);
//        System.out.println(visitor.getResult());

        Path path2 = Paths.get("D:\\Coding\\Обучение\\it-park\\Homeworks\\Multithreading " +
                "(Final Project)\\target\\multi-threading-1.0\\upload");
        final FileVisitor2 visitor2 = new FileVisitor2();
        visitor2.setSearchString("Hello");
        Path result = Paths.get("D:\\Coding\\Обучение\\it-park\\Homeworks\\Multithreading (Final Project)\\target\\multi-threading-1.0\\result");
        Files.createDirectories(result);
        Files.walkFileTree(path2, visitor2);

        String absolutePath = new File(".").getAbsolutePath();

        System.out.println("Абсолютный путь! " + absolutePath);


        //System.out.println(System.getenv());
//        final Method post = Class.forName("ru.itpark.servlet.Servlet").getMethod("doPost");
        //Files.delete(path2);


        // fileSearch.parseFile(path, searchString);
        // fileSearch.parseFilePattern("Am am amama", "am");

        //fileService.getAll();
//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//        String resultFile =  dateFormat.toLocalizedPattern();
//        System.out.println(resultFile);
    }
}
