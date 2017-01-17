package com.gt.main;

import com.gt.domain.Person;
import com.gt.domain.PersonAgeComparator;
import com.gt.utils.CSVReader;
import org.joda.time.Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by aydingungordu on 1/14/17.
 */
public class AddressBook {

    protected final List<Person> people = new ArrayList<>();

    public AddressBook(final String filename) {
        initializePeopleList(filename);
    }

    /**
     * Initialize entire address book into memory
     */
    private void initializePeopleList(final String filename) {
        CSVReader csvReader = new CSVReader(filename);

        while (csvReader.hasNextLine()) {
            people.add(new Person(csvReader.getNextLineTokens()));
        }
    }

    /**
     * Counts people in the address book by gender
     *
     * @param  gender to count
     * @return the number of people of the specified gender
     * <p>
     * Assuming that this class may be extended to add people who are not in the CSV file.
     */
    public long countPeopleOfGender(final Person.Gender gender) {
        return people.stream().filter(person -> person.getGender().equals(gender)).count();
    }

    /**
     * Gets the oldest person from the people list
     *
     * @return the oldest person
     * @throws NoSuchElementException if there are no people in the list
     * <p>
     * Assuming that this class may be extended to add people who are not in the CSV file.
     * What if there is a tie for the oldest person? Should I return a list instead?
     */
    public Person getOldestPerson() {
        return people.stream().min(new PersonAgeComparator()).get();
    }

    /**
     * Gets the age difference in days between two people
     *
     * @param  personOne
     * @param  personTwo
     * @return the age difference in days between personOne and personTwo
     */
    public static int getAgeDifferenceInDays(final Person personOne, final Person personTwo) {
        if (Objects.nonNull(personOne) && Objects.nonNull(personTwo)) {
            return Math.abs(Days.daysBetween(personOne.getDateOfBirth(), personTwo.getDateOfBirth()).getDays());
        }
        return -1;
    }
}
