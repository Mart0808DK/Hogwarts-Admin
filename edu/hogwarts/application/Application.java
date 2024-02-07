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
        app.pageLoad();
    }

    public void pageLoad() {
        var startApp = new InitApp();
        var userInterface = new UserInterface();
        var studentController = new StudentController();
        var teacherController = new TeacherController();

        startApp.pageLoad();
    }




}
