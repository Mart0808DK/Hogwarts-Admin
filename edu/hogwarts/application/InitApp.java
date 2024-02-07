package edu.hogwarts.application;
import edu.hogwarts.data.*;

import java.time.LocalDate;
import java.util.Arrays;

public class InitApp {
    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();

    public void pageLoad() {
        pageLoadStudents();
    }

    public void pageLoadStudents() {
        var harry = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch"}, 1991, 1998, false, "Harry James Potter", LocalDate.of(1980, 7, 31));
        var ron = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch", "Wizard Chess"}, 1991, 1998, false, "Ronald Bilius Weasley", LocalDate.of(1980, 3, 1));
        var studentsGryffindor = new HogwartsStudent[]{harry, ron};

        studentController.createMoreStudents(studentsGryffindor);

        System.out.println(Arrays.toString(studentsGryffindor));
    }

    public void pageLoadHogwartsTeachers() {

    }
}
