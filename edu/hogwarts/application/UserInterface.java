package edu.hogwarts.application;

import edu.hogwarts.data.HogwartsPerson;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void start() {
        menu.startMenu();
        int userSelect = scanner.nextInt();

        switch (userSelect) {
            case 1:
                handleCreateMenu();
                break;
            case 2:
                handleViewMenu();
                break;
            case 3:
                handleSortMenu();
                break;
            case 4:
                handleFilterMenu();
                break;
            default:
                System.out.println("Invalid selection. Please choose a valid option.");
        }
    }

    private void handleCreateMenu() {
        menu.createMenu();
        int createSelection = scanner.nextInt();
        // Handle submenu options if necessary
        // For now, let's just return to the start menu
        start();
    }

    private void handleViewMenu() {
        menu.viewMenu();
        int viewSelection = scanner.nextInt();

        switch (viewSelection) {
            case 1:
                viewStudent();
                break;
            case 2:
                viewTeacher();
                break;
            case 3:
                viewAll();
            default:
                System.out.println("Invalid selection. Please choose a valid option.");
        }
    }


    public void viewStudent() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsStudent student : allStudents) {
            System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                    student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                    student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
        }
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void viewTeacher() {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();

        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
        System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsTeacher teacher : allTeachers) {
            System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                    teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                    teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void viewAll() {
        List<HogwartsPerson> allPeople = new ArrayList<>();
        allPeople.addAll(studentController.getAll());
        allPeople.addAll(teacherController.getAll());

        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
        System.out.println("│ Full Name                      │ Role       │ Employment Start│ Employment End  │ House      │ Head of House │ Enrollment │ Graduation │ Graduated ");
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        for (HogwartsPerson person : allPeople) {
            if (person instanceof HogwartsStudent) {
                HogwartsStudent student = (HogwartsStudent) person;
                System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b │ %-10d │ %-10d │ %-9b\n",
                        student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                        student.getGraduationYear(), student.getHouse().getName(), Arrays.toString(student.getTeams()),
                        student.getEnrollmentYear(), student.getGraduationYear(), student.isGraduated());
            } else if (person instanceof HogwartsTeacher) {
                HogwartsTeacher teacher = (HogwartsTeacher) person;
                System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b │ %-10s │ %-10s │ %-9s\n",
                        teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                        teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse(),
                        "N/A", "N/A", "N/A");
            }
        }

        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }




    private void handleSortMenu() {
        menu.sortMenu();
        int sortSelection = scanner.nextInt();
        // Handle submenu options if necessary
        // For now, let's just return to the start menu
        start();
    }

    private void handleFilterMenu() {
        menu.filterMenu();
        int filterSelection = scanner.nextInt();
        // Handle submenu options if necessary
        // For now, let's just return to the start menu
        start();
    }


}
