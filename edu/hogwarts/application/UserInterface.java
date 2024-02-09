package edu.hogwarts.application;

import edu.hogwarts.data.*;
import edu.utility.FilterData;
import edu.utility.SortData;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
        switch (createSelection) {
            case 1:
                createStudent();
                break;
            case 2:
                createTeacher();
                break;
            default:
                System.out.println("Invalid selection");

        }
        // Handle submenu options if necessary
        // For now, let's just return to the start menu
        start();
    }

    public void createStudent() {
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String fullName = scanner.nextLine();

        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Enter student birthdate (yyyy-mm-dd): ");
                birthdate = LocalDate.parse(scanner.nextLine());
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format:");
            }
        }

        System.out.println("Enter if student is a prefect (true/false): ");
        boolean isPrefect = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house;
        switch (houseOrigin) {
            case GRYFFINDOR:
                house = House.getGryffindor();
                break;
            case HUFFLEPUFF:
                house = House.getHufflepuff();
                break;
            case RAVENCLAW:
                house = House.getRavenclaw();
                break;
            case SLYTHERIN:
                house = House.getSlytherin();
                break;
            default:
                System.out.println("Invalid house. Please choose again.");
                menu.startMenu();
                return;
        }

        System.out.println("Enter start year: ");
        int startYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter end year: ");
        int endYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter teams (comma-separated): ");
        String[] teams = scanner.nextLine().split(",");

        System.out.println("Enter if you are graduated: ");
        boolean graduated = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        HogwartsStudent student = new HogwartsStudent(house, isPrefect, teams, startYear, endYear, graduated, fullName, birthdate);
        studentController.add(student);

        System.out.println("Student was created");
        System.out.println("Press any key to return to the main menu.");
        scanner.nextLine(); // Consume newline
        menu.startMenu();
    }




    public void createTeacher() {
        scanner.nextLine();
        System.out.print("Enter teacher name: ");
        String fullName = scanner.nextLine();

        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Enter teacher birthdate (yyyy-mm-dd): ");
                birthdate = LocalDate.parse(scanner.nextLine());
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            }
        }

        System.out.print("Is the teacher head of house? (true/false): ");
        boolean headOfHouse = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house;
        switch (houseOrigin) {
            case GRYFFINDOR:
                house = House.getGryffindor();
                break;
            case HUFFLEPUFF:
                house = House.getHufflepuff();
                break;
            case RAVENCLAW:
                house = House.getRavenclaw();
                break;
            case SLYTHERIN:
                house = House.getSlytherin();
                break;
            default:
                System.out.println("Invalid house. Please choose again.");
                menu.startMenu();
                return;
        }

        LocalDate employmentStart = null;
        LocalDate employmentEnd = null;
        try {
            System.out.print("Enter employment start date (yyyy-mm-dd): ");
            employmentStart = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter employment end date (yyyy-mm-dd): ");
            employmentEnd = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            menu.startMenu();
            return;
        }

        HogwartsTeacher teacher = new HogwartsTeacher(house, headOfHouse, employmentStart, employmentEnd, fullName, birthdate);
        teacherController.add(teacher);

        System.out.println("Teacher was created");
        System.out.println("Press any key to return to the main menu.");
        scanner.nextLine(); // wait for user input
        menu.startMenu();
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
        switch (sortSelection) {
            case 1:
                menu.innerSortStudentsMenu();
                handleInnerSortStudentMenu();
                break;
            case 2:
                menu.innerSortTeacherMenu();
                handleInnerSortTeacherMenu();
            case 3:
                menu.startMenu();
        }
    }

    private void handleInnerSortStudentMenu() {
        int sortChoice = scanner.nextInt();
        SortData sortData = new SortData(studentController, teacherController);
        switch (sortChoice) {
            case 1:
                System.out.println("In nr one");
                var studentNameAsc = sortData.sortStudentsNameAsc();
                System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
                System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsStudent student : studentNameAsc) {
                    System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                            student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                            student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
                }
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");
                break;
            case 2:
                System.out.println("In nr two");
                var studentNameDesc = sortData.sortStudentsNameDesc();
                System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
                System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsStudent student : studentNameDesc) {
                    System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                            student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                            student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
                }
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");

                break;
            case 3:
                System.out.println("In nr three");
                var studentAgeAsc = sortData.sortedStudentAgeAsc();
                System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
                System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsStudent student : studentAgeAsc) {
                    System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                            student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                            student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
                }
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");

                break;
            case 4:
                System.out.println("In nr four");
                var studentAgeDesc =  sortData.sortedStudentAgeDesc();
                System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
                System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsStudent student : studentAgeDesc) {
                    System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                            student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                            student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
                }
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");

        }
    }

    private void handleInnerSortTeacherMenu() {
        int sortChoice = scanner.nextInt();
        SortData sortData = new SortData(studentController, teacherController);
        switch (sortChoice) {
            case 1:
                System.out.println("In nr one");
                var teacherNameAsc = sortData.sortedTeacherNameAsc();
                System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
                System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
                System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsTeacher teacher : teacherNameAsc) {
                    System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                            teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                            teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
                }
                System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                break;
            case 2:
                System.out.println("In nr two");
                var teacherNameDesc = sortData.sortedTeacherNameDesc();
                System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
                System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
                System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsTeacher teacher : teacherNameDesc) {
                    System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                            teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                            teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
                }
                System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                break;
            case 3:
                System.out.println("In nr three");
                var teacherAgeAsc = sortData.sortedTeacherAgeAsc();
                System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
                System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
                System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsTeacher teacher : teacherAgeAsc) {
                    System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                            teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                            teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
                }
                System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

                break;
            case 4:
                System.out.println("In nr four");
                var teacherAgeDesc =  sortData.sortedTeacherAgeDesc();
                System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
                System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
                System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsTeacher teacher : teacherAgeDesc) {
                    System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                            teacher.getFullName(), teacher.getRole(), teacher.getEmploymentStart(),
                            teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
                }
                System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        }
    }

    private void handleFilterMenu() {
        menu.filterMenu();
        int filterSelection = scanner.nextInt();
        switch (filterSelection) {
            case 1:
                System.out.println("Students");
                menu.innerFilterStudentsMenu();
                handleInnerStudentsFilter();
                break;
            case 2:
                System.out.println("Teachers");
                menu.innerFilterTeacherMenu();
                break;
        }
    }

    private void handleInnerStudentsFilter() {
        int filterChoice = scanner.nextInt();
        FilterData filterData = new FilterData(studentController, teacherController);
        switch (filterChoice) {
            case 1:
                scanner.nextLine();
                System.out.print("Write House Name: ");
                String houseName = scanner.nextLine().toUpperCase();
                List<HogwartsStudent> houseFiltered = filterData.filterStudentHouse(houseName);
                System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
                System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
                for (HogwartsStudent student : houseFiltered) {
                    System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                            student.getFullName(), student.getRole(), student.getEnrollmentYear(),
                            student.getGraduationYear(), student.isGraduated(), houseName);
                }
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");
                break;
            case 2:
                System.out.println("Hej");
                break;
        }
    }



}
