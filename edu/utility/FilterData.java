package edu.utility;

import edu.generic.empType;
import edu.hogwarts.application.StudentController;
import edu.hogwarts.application.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;
import edu.hogwarts.data.HouseOrigin;

import java.util.List;
import java.util.stream.Collectors;

public class FilterData {
    private final StudentController studentController;
    private final TeacherController teacherController;

    public FilterData(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public List<HogwartsStudent> filterStudentHouse(HouseOrigin houseName) {
        return studentController.getAll()
                .stream()
                .filter(student -> student.getHouse().getName().equals(houseName))
                .toList();
    }
    public List<HogwartsTeacher> filterTeacherHouse(HouseOrigin houseName) {
        return teacherController.getAll()
                .stream()
                .filter(student -> student.getHouse().getName().equals(houseName))
                .toList();
    }

    public List<HogwartsStudent> filterStudentGraduation(Boolean graduated) {
        return studentController.getAll().stream()
                .filter(student -> student.isGraduated() == graduated)
                .collect(Collectors.toList());
    }

    public List<HogwartsTeacher> filterTeacherHeadOfHouse(Boolean headOfHouse){
        return teacherController.getAll().stream().filter(hogwartsTeacher -> hogwartsTeacher.isHeadOfHouse() == headOfHouse).collect(Collectors.toList());
    }


    public List<HogwartsStudent> filterRole(empType role) {
        return studentController.getAll()
                .stream()
                .filter(student -> student.getRole() == role)
                .collect(Collectors.toList());
    }

}
