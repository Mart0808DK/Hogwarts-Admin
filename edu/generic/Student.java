package edu.generic;

import edu.generic.Person;

public class Student extends Person {
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;

    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullname) {
        super(fullname);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student() {
    }

    public String toString() {
        return "edu.generic.Student{\n" +
                "fullName" + getFullName() + "\n" +
                "enrollmentYear: " + enrollmentYear + "\n" +
                "graduationYear: " + graduationYear + "\n" +
                "graduated: " + graduated + "\n" +
                "}";
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