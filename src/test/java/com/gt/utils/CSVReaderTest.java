package com.gt.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class CSVReaderTest {

    @Test
    public void readLineTest() {

        CSVReader csvReader = new CSVReader("address-book.csv");
        String[] lineTokens = csvReader.getNextLineTokens();

        assertEquals("Bill McKnight", lineTokens[0]);
        assertEquals("Male",lineTokens[1]);
        assertEquals("16/03/77", lineTokens[2]);

    }
}
