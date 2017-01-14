package com.gt.domain;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class Person {

    public Person(final String[] personString) {
        this.name = personString[0];
        this.gender = Gender.valueOf(personString[1].toUpperCase());
        this.dateOfBirth = DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime(personString[2]);
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHER;

    }

    private final DateTime dateOfBirth;
    private final String name;
    private final Gender gender;

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }


}
