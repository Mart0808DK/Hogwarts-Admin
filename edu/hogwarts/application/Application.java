package edu.hogwarts.application;

import edu.generic.empType;
import edu.hogwarts.data.*;

import java.time.LocalDate;

public class Application {
    InitApp initApp;

    UserInterface userInterface;

    StudentController studentController;

    TeacherController teacherController;
    public static void main(String[] args) {
        Application app = new Application();
        app.startApp();
    }

    public void startApp() {
        var initApp = new InitApp();
        initApp.pageLoad();

    }




}
