package edu.hogwarts.model;

import edu.generic.Student;

import java.time.LocalDate;
import java.util.Arrays;

public class YearGroup {
    private int schoolYear;
    private LocalDate beginningOfSchoolYear;

    private Student[] students;

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear, Student[] students) {
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = students;
    }

    public YearGroup(){}

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "edu.hogwarts.data.YearGroup{" +
                "schoolYear=" + schoolYear +
                ", beginningOfSchoolYear=" + beginningOfSchoolYear +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
