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

    public DemographicsCalculator(final String filename) {
        initializePeopleList(filename);
    }

    private void initializePeopleList(final String filename) {
        CSVReader csvReader = new CSVReader(filename);

        while (csvReader.hasNextLine()) {
            people.add(new Person(csvReader.getNextLineTokens()));
        }
    }

    /**
     * Could actually count different genders while reading the file, and hold them as constants,
     * but assuming instead that this class may be extended to add people who are not in the CSV file
     */
    public long countPeopleOfGender(final Person.Gender gender) {
        return people.stream().filter(person -> person.getGender().equals(gender)).count();
    }

    /**
     * Could actually find the oldest person while reading the file, and hold it as constant,
     * but assuming instead that this class may be extended to add people who are not in the CSV file
     */
    public Person getOldestPerson() {
        return people.stream().min(new PersonAgeComparator()).get();
    }

    public static int getAgeDifference(final Person personOne, final Person personTwo) {
        return Math.abs(Days.daysBetween(personOne.getDateOfBirth(), personTwo.getDateOfBirth()).getDays());
    }
}
