package edu.generic;

import edu.generic.Person;

import java.time.LocalDate;

public class Student extends Person {

    private empType role = empType.STUDENT;
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;
    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullname, LocalDate birthDate) {
        super(fullname, birthDate);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "role=" + getRole() +
                ", enrollmentYear=" + getEnrollmentYear() +
                ", graduationYear=" + getGraduationYear() +
                ", graduated=" + isGraduated() +
                '}';
    }

    public empType getRole() {
        return role;
    }

    public void setRole(empType role) {
        this.role = role;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }
}