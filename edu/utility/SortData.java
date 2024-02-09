package edu.utility;

import edu.hogwarts.application.StudentController;
import edu.hogwarts.application.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.Comparator;
import java.util.List;

public class SortData {
    private final StudentController studentController;
    private final TeacherController teacherController;

    public SortData(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    // Sort on fullname

    public List<HogwartsStudent> sortStudentsNameAsc(){
        return studentController.sortAllStudents(Comparator.comparing(HogwartsStudent::getFullName));
    }

    public List<HogwartsStudent> sortStudentsNameDesc() {
        return studentController.sortAllStudents(Comparator.comparing(HogwartsStudent::getFullName).reversed());
    }


    public List<HogwartsTeacher> sortedTeacherNameAsc() {
        return teacherController.sortAllTeachers(Comparator.comparing(HogwartsTeacher::getFullName));
    }
    public List<HogwartsTeacher> sortedTeacherNameDesc() {
        return teacherController.sortAllTeachers(Comparator.comparing(HogwartsTeacher::getFullName).reversed());
    }

    // sort Age

    public List<HogwartsStudent> sortedStudentAgeAsc() {
        return studentController.sortAllStudents(Comparator.comparing(HogwartsStudent::getAge));
    }
    public List<HogwartsStudent> sortedStudentAgeDesc() {
        return studentController.sortAllStudents(Comparator.comparing(HogwartsStudent::getAge).reversed());
    }

    public List<HogwartsTeacher> sortedTeacherAgeAsc() {
        return teacherController.sortAllTeachers(Comparator.comparing(HogwartsTeacher::getAge));
    }
    public List<HogwartsTeacher> sortedTeacherAgeDesc() {
        return teacherController.sortAllTeachers(Comparator.comparing(HogwartsTeacher::getAge).reversed());
    }
}
