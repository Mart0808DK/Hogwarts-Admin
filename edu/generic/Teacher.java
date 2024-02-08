package edu.generic;

import java.time.LocalDate;

public class Teacher extends Person {
    private empType role = empType.TEACHER;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(empType role, LocalDate employmentStart, LocalDate employmentEnd, String fullname, LocalDate birthDate) {
        super(fullname, birthDate);
        this.role = role;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher() {
        // Default constructor
    }


    public Teacher(LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthDate) {
        super(fullName, birthDate);
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;

    }

    // Getters and setters

    public empType getRole() {
        return role;
    }

    public void setRole(empType role) {
        this.role = role;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }
}
