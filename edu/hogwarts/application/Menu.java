package edu.hogwarts.application;

public class Menu {
    private static final String lineBreak = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";

    public void startMenu() {
        System.out.println("Welcome to Hogwarts Administration. Here you can create, edit, and delete Hogwarts students and teachers");
        System.out.println(lineBreak);

        System.out.println("1. Create");
        System.out.println("2. View");
        System.out.println("3. Sort");
        System.out.println("4. Filter");
        System.out.println(lineBreak);

    }

    public  void createMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Create Student");
        System.out.println("2. Create Teacher");
        System.out.println(lineBreak);
    }

    public void viewMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println("3. View All");
        System.out.println(lineBreak);
    }

    public void sortMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println(lineBreak);
    }

    public void filterMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println(lineBreak);
    }

    public void innerSortMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println(lineBreak);
    }

    public void innerFilterStudentsMenu() {
        System.out.println(lineBreak);
        System.out.println("1. House");
        System.out.println("2. Teams");
        System.out.println(lineBreak);
    }
    public void innerFilterTeacherMenu() {
        System.out.println(lineBreak);
        System.out.println("1. House");
        System.out.println("2. Head Of House");
        System.out.println(lineBreak);
    }



}
