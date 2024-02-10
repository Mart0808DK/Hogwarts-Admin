package edu.hogwarts.model;

import edu.generic.Teacher;

import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {
    private House house;

    private boolean headOfHouse;

    public HogwartsTeacher(){}

    public HogwartsTeacher(House house, boolean headOfHouse, LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthDate) {
        super(employmentStart, employmentEnd, fullName, birthDate);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }


    public HogwartsTeacher(House house, boolean headOfHouse) {
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    @Override
    public String toString() {
        return "edu.hogwarts.data.HogwartsTeacher{\n" +
                " fullName: " + getFullName() + "\n" +
                " employment: " + getRole() + "\n" +
                " employmentStart: " + getEmploymentStart() + "\n" +
                " employmentEnd: " + getEmploymentEnd() + "\n" +
                " house: " + house.getName() + "\n" +
                " headOfHouse: " + headOfHouse + "\n" +
                "}";
    }
}
