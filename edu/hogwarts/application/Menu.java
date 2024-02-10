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
        System.out.println("0. Exit");
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
        System.out.println("3. Back to StartPage");
        System.out.println(lineBreak);
    }

    public void filterMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println(lineBreak);
    }

    public void innerSortStudentsMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Name ascending");
        System.out.println("2. Name descending");
        System.out.println("3. Age ascending");
        System.out.println("4. Age descending");
        System.out.println(lineBreak);
    }
    public void innerSortTeacherMenu() {
        System.out.println(lineBreak);
        System.out.println("1. Name ascending");
        System.out.println("2. Name descending");
        System.out.println("3. Age ascending");
        System.out.println("4. Age descending");
        System.out.println(lineBreak);
    }

    public void innerFilterStudentsMenu() {
        System.out.println(lineBreak);
        System.out.println("1. House");
        System.out.println("2. Graduated");
        System.out.println(lineBreak);
    }
    public void innerFilterTeacherMenu() {
        System.out.println(lineBreak);
        System.out.println("1. House");
        System.out.println("2. Head Of House");
        System.out.println(lineBreak);
    }

    public void filterByHouse(){
        System.out.println(lineBreak);
        System.out.println("1. GRYFFINDOR");
        System.out.println("2. HUFFELPUFF");
        System.out.println("3. RAVENCLAW");
        System.out.println("4. SLYTHERIN");
        System.out.println(lineBreak);
    }


}
