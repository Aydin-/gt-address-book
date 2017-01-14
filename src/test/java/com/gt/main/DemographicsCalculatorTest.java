package com.gt.main;

import com.gt.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aydingungordu on 1/14/17.
 *
 *  - How many males are in the address book?
 *  - Who is the oldest person in the address book?
 *  - How many days older is Bill than Paul?
 */

public class DemographicsCalculatorTest {

    private DemographicsCalculator dc;

    @Before
    public void init(){
        this.dc = new DemographicsCalculator("address-book.csv");
    }

    @Test
    public void genderCountTest(){
        assertEquals(3, dc.countPeopleOfGender(Person.Gender.MALE));
    }

    @Test
    public void findOldestPersonTest(){
        assertEquals("Wes Jackson", dc.getOldestPerson().getName());
    }

    @Test
    public void compareAgesTest(){
        Person bill = new Person("Bill McKnight, Male, 16/03/77".split(", "));
        Person paul = new Person("Paul Robinson, Male, 15/01/85".split(", "));
        assertEquals(2862, DemographicsCalculator.getAgeDifference(bill, paul));
        assertEquals(2862, DemographicsCalculator.getAgeDifference(paul, bill));
        assertEquals(0, DemographicsCalculator.getAgeDifference(paul, paul));
    }

}
