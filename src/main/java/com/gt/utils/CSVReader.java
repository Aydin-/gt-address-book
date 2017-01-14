package com.gt.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class CSVReader {

    private final String filename;
    private List<String> allLines;
    private int index = 0;

    public CSVReader(String filename) {
        this.filename = filename;

        try (Stream<String> stream = Files.lines(Paths.get(this.getClass().getClassLoader().getResource(filename).getPath()))) {
            allLines = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNextLine() {
        if (index < allLines.size()) {
            return true;
        }
        return false;
    }

    public String[] getNextLineTokens() {
        if (index >= allLines.size()) {
            return null;
        }

        String[] retval = allLines.get(index).split(", ");
        index++;
        return retval;
    }

}
