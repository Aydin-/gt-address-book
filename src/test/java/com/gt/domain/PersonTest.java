package com.gt.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class PersonTest {

    @Test
    public void parsePersonTest() {
        Person bill = new Person("Bill McKnight, Male, 16/03/77".split(", "));
        assertEquals("Bill McKnight", bill.getName());
        assertEquals(Person.Gender.MALE, bill.getGender());
        assertEquals(16, bill.getDateOfBirth().getDayOfMonth());
        assertEquals(77, bill.getDateOfBirth().getYear());
        assertEquals(3, bill.getDateOfBirth().getMonthOfYear());
    }
}
