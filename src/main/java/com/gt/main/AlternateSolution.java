package com.gt.main;

import com.gt.domain.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by aydingungordu on 1/14/17.
 */
public class AlternateSolution {

    public static void main(String[] args) {
        printSolution();
    }

    public static void printSolution() {
        try (InputStream inputStream = AlternateSolution.class.getClassLoader().getResourceAsStream("address-book.csv")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String line;
            Person oldestPerson = null;
            int numMales = 0;
            Person bill = null;
            Person paul = null;

            while ((line = br.readLine()) != null) {
                Person person = new Person(line.split(", "));
                if (person.getGender().equals(Person.Gender.MALE)) {
                    numMales++;
                }
                if (person.getName().equals("Bill McKnight")) {
                    bill = person;
                } else if (person.getName().equals("Paul Robinson")) {
                    paul = person;
                }
                if (Objects.isNull(oldestPerson) || person.getDateOfBirth().isBefore(oldestPerson.getDateOfBirth())) {
                    oldestPerson = person;
                }
            }

            System.out.println("There are " + numMales + " males in the address book");
            System.out.println("The oldest person is " + oldestPerson.getName());
            System.out.println("Bill is " + DemographicsCalculator.getAgeDifferenceInDays(bill, paul) + " days older than Paul");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
