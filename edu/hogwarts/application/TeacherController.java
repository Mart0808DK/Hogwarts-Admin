package edu.hogwarts.application;

import edu.generic.Teacher;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherController extends Controller<HogwartsTeacher> {

    private final HashMap<UUID, HogwartsTeacher> teacherList;

    public TeacherController() {
        this.teacherList = new HashMap<>();
    }
    public void add(HogwartsTeacher... teachers) {
        for (var student : teachers) {
            teacherList.put(student.getId(), student);
        }
    }

    public void add(HogwartsTeacher teacher) {
        teacherList.put(teacher.getId(), teacher);
    }


    public HogwartsTeacher get(UUID id) {
        return teacherList.get(id);
    }

    public ArrayList<HogwartsTeacher> getAll() {
        return new ArrayList<HogwartsTeacher>(teacherList.values());
    }

    public void update(UUID id, HogwartsTeacher updatedTeacher) {
        HogwartsTeacher existingTeacher = teacherList.get(id);
        if (existingTeacher != null) {
            existingTeacher.setFullName(updatedTeacher.getFullName());
            existingTeacher.setHouse(updatedTeacher.getHouse());
            existingTeacher.setHeadOfHouse(updatedTeacher.isHeadOfHouse());
            existingTeacher.setRole(updatedTeacher.getRole());
            existingTeacher.setEmploymentStart(updatedTeacher.getEmploymentStart());
            existingTeacher.setEmploymentEnd(updatedTeacher.getEmploymentEnd());
        }
    }

    public void delete(UUID id) {
        teacherList.remove(id);
    }
}
