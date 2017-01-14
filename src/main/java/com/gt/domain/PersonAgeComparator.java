package com.gt.domain;

import java.util.Comparator;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
