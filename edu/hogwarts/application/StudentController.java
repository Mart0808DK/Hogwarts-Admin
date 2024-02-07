package edu.hogwarts.application;

import edu.hogwarts.data.HogwartsStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class StudentController {
    HashMap<UUID, HogwartsStudent> studentsList;

    public StudentController() {
        studentsList = new HashMap<>();
    }

    public void createMoreStudents(HogwartsStudent... students) {
        for (var student : students) {
            studentsList.put(student.getId(), student);
        }
    }

    public HogwartsStudent getStudent(UUID id) {
        return studentsList.get(id);
    }

    public ArrayList<HogwartsStudent> getAllStudent() {
         return new ArrayList<HogwartsStudent>(studentsList.values());
    }

    public void updateStudent(UUID id, HogwartsStudent updatedStudent) {
        HogwartsStudent existingStudent = studentsList.get(id);

        if (existingStudent != null) {
            existingStudent.setFullName(updatedStudent.getFullName());
            existingStudent.setEnrollmentYear(updatedStudent.getEnrollmentYear());
            existingStudent.setGraduationYear(updatedStudent.getGraduationYear());
            existingStudent.setGraduated(updatedStudent.isGraduated());
            existingStudent.setTeams(updatedStudent.getTeams());
            existingStudent.setPrefect(updatedStudent.isPrefect());
            existingStudent.setHouse(updatedStudent.getHouse());

            studentsList.put(id, existingStudent);
        } else {
            System.out.println("Student with ID " + id + " does not exist.");
        }
    }



    public void deleteStudent(UUID id) {
        studentsList.remove(id);
    }


}
