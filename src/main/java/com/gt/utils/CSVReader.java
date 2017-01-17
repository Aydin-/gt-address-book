package com.gt.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aydingungordu on 1/14/17.
 * <p>
 * Design choice: Writing own CSVReader in a few lines could be easier than managing third party dependency.
 */
public class CSVReader {

    private final List<String> allLines = new ArrayList<>();
    private int index = 0;

    public CSVReader(final String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(this.getClass().getClassLoader().getResource(filename).getPath()))) {
            allLines.addAll(stream.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNextLine() {
        return index < allLines.size();
    }

    public String[] getNextLineTokens() {
        if (index >= allLines.size()) {
            return null;
        }
        return allLines.get(index++).split(", ");
    }

}
