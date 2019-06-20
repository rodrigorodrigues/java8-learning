package com.learning.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public List<String> readFileJava8(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    public List<String> readFileOldWay(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //Ugly code, example bizarre of 'Decorator Pattern'
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
