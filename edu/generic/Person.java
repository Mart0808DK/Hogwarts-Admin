package edu.generic;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;

    private LocalDate birthDate;

    private UUID id;

    public Person(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Person() {
        this.id = UUID.randomUUID();
    }

    public Person(String firstName, String middleName, String lastName) {
            this();
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
    }

    public Person(String fullName, LocalDate birthDate) {
        setFullName(fullName);
        this.birthDate = birthDate;
    }

    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.middleName = other.middleName;
    }

    // getters og setters før atributter


    public UUID getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        LocalDate hogwartsYear1991 = LocalDate.of(1991, 9, 1); // Date from the year 1991
        Period period = Period.between(hogwartsYear1991, getBirthDate());
        return Math.abs(period.getYears()); // Return the absolute value of the years
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void  setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        if (hasMiddleName()) {
        return firstName + " " + middleName + " " + lastName;
        } else {
        return firstName + " " + lastName;
        }
    }

    public void setFullName(String fullName) {
        int firstSpaceIndex = fullName.indexOf(" ");
        int lastSpaceIndex = fullName.lastIndexOf(" ");

        if (firstSpaceIndex != -1) {
            firstName = fullName.substring(0, firstSpaceIndex);

            if (lastSpaceIndex > firstSpaceIndex) {
                middleName = fullName.substring(firstSpaceIndex + 1, lastSpaceIndex);
                lastName = fullName.substring(lastSpaceIndex + 1);
            } else {
                lastName = fullName.substring(firstSpaceIndex + 1);
            }
        } else {
            firstName = fullName;
            middleName = null;
            lastName = null;
        }
    }

    public String getFullName() {
        if (hasMiddleName() && getMiddleName() != null) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public boolean hasMiddleName() {
        return middleName != null;
    }

};

