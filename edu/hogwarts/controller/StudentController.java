package edu.hogwarts.controller;

import edu.hogwarts.model.HogwartsStudent;

import java.util.*;

public class StudentController extends Controller<HogwartsStudent> {
    private final HashMap<UUID, HogwartsStudent> students = new HashMap<>();

    public StudentController() {
        super();
    }

    public ArrayList<HogwartsStudent> getAll() {
        return new ArrayList<>(this.students.values());
    }

    public HogwartsStudent get(UUID id) {
        return students.get(id);
    }

    public void add(HogwartsStudent student) {
        students.put(student.getId(), student);
    }

    public void add(HogwartsStudent[] students) {
        for (var student : students) {
            add(student);
        }
    }

    public List<HogwartsStudent> sortAllStudents(Comparator<HogwartsStudent> comparator) {
        List<HogwartsStudent> sortedList = getAll();
        sortedList.sort(comparator);
        return sortedList;
    }

    public void update(UUID id, HogwartsStudent student) {
        var oldStudent = get(id);
        assert oldStudent != null;
        oldStudent.setFullName(student.getFullName());
        oldStudent.setBirthDate(student.getBirthDate());
        oldStudent.setHouse(student.getHouse());
        oldStudent.setPrefect(student.isPrefect());
        oldStudent.setTeams(student.getTeams());
        oldStudent.setEnrollmentYear(student.getEnrollmentYear());
        oldStudent.setGraduationYear(student.getGraduationYear());
        oldStudent.setGraduated(student.isGraduated());

    }

    public void delete(UUID id) {
        students.remove(id);
    }
}
