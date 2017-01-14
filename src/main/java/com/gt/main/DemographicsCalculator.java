package com.gt.main;

import com.gt.domain.Person;
import com.gt.domain.PersonAgeComparator;
import com.gt.utils.CSVReader;
import org.joda.time.Days;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aydingungordu on 1/14/17.
 */
public class DemographicsCalculator {

    private List<Person> people = new ArrayList<>();

    public DemographicsCalculator(String filename) {
        CSVReader csvReader = new CSVReader(filename);

        while (csvReader.hasNextLine()) {
            people.add(new Person(csvReader.getNextLineTokens()));
        }
    }

    public long countPeopleOfGender(Person.Gender gender) {
        return people.stream().filter(person -> person.getGender().equals(gender)).count();
    }

    public Person getOldestPerson() {
        return people.stream().min(new PersonAgeComparator()).get();
    }

    public static int getAgeDifference(Person personOne, Person personTwo) {
        return Math.abs(Days.daysBetween(personOne.getDateOfBirth(), personTwo.getDateOfBirth()).getDays());
    }
}
