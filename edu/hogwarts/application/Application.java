package edu.hogwarts.application;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.startApp();
    }

    public void startApp() {
        var initApp = new InitApp();
        initApp.pageLoad();

    }




}
