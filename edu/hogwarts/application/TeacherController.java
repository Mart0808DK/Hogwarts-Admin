package edu.hogwarts.application;

import edu.generic.Teacher;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherController {

    HashMap<UUID, HogwartsTeacher> teacherList;

    public void createMoreStudents(HogwartsTeacher... teachers) {
        for (var student : teachers) {
            teacherList.put(student.getId(), student);
        }
    }

    public HogwartsTeacher getTeacher(UUID id) {
        return teacherList.get(id);
    }

    public ArrayList<HogwartsTeacher> getAllTeacher() {
        return new ArrayList<HogwartsTeacher>(teacherList.values());
    }

    public void updateStudent(UUID id, HogwartsTeacher updatedTeacher) {
        HogwartsTeacher existingTeacher = teacherList.get(id);
        if (existingTeacher != null) {
            existingTeacher.setFullName(updatedTeacher.getFullName());
            existingTeacher.setHouse(updatedTeacher.getHouse());
            existingTeacher.setHeadOfHouse(updatedTeacher.isHeadOfHouse());
            existingTeacher.setEmployment(updatedTeacher.getEmployment());
            existingTeacher.setEmploymentStart(updatedTeacher.getEmploymentStart());
            existingTeacher.setEmploymentEnd(updatedTeacher.getEmploymentEnd());
        }
    }

    public void deleteStudent(UUID id) {
        teacherList.remove(id);
    }
}
