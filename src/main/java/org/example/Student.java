package org.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;

public class Student {
    private final String firstName;
    private final String lastName;
    private final DateOfBirth dateOfBirth;
    private final Gender gender;
    private final String id;
    private int age;




    public Student(String firstName, String lastName, DateOfBirth dateOfBirth, Gender gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }
    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();

            LocalDate birthDate = LocalDate.of(dateOfBirth.year, dateOfBirth.month, dateOfBirth.day);
            Period period = Period.between(birthDate, currentDate);
            //System.out.println("currentDate: "+currentDate +"/ birthdayDate: "+ birthDate);
            return period.getYears();

    }



    @Override
    public String  toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", id='" + id + '\'' +
                '}';
    }
}
