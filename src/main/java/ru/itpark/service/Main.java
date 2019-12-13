package ru.itpark.service;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextSearch fileSearch = new TextSearch();
        String path = "Destination/rfc1945.txt";
        //String path = "Destination/testpack.txt";
        fileSearch.parseFile(path, "HTTP");

    }
}
