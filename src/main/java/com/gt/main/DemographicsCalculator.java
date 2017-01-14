package com.gt.main;

import com.gt.domain.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aydingungordu on 1/14/17.
 */
public class DemographicsCalculator {

    private List<Person> people = new ArrayList<>();

    public DemographicsCalculator(String filename) {

    }

    public int countPeopleOfGender(Person.Gender gender) {
        return -1;
    }

    public Person getOldestPerson() {
        return new Person(null);
    }

    public static int getAgeDifference(Person personOne, Person personTwo) {
        return -1;
    }
}
