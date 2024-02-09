package edu.utility;

import edu.hogwarts.application.StudentController;
import edu.hogwarts.application.TeacherController;
import edu.hogwarts.data.HogwartsStudent;

import java.util.List;
import java.util.stream.Collectors;

public class FilterData {
    private final StudentController studentController;
    private final TeacherController teacherController;

    public FilterData(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public List<HogwartsStudent> filterStudentHouse(String houseName) {
        return studentController.getAll()
                .stream()
                .filter(student -> student.getHouse().equalsHouse(houseName)).toList();
    }

    public List<HogwartsStudent> filterTeams(String[] teams) {
        return studentController.getAll()
                .stream()
                .filter(student -> student.getHouse().equals(teams)).toList();
    }

}
