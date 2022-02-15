 ```mermaid
    graph TD;
        src-->main;
        src-->test;
        main-->java;
        main-->resources;
        resources-->META-INF;
        META-INF-->persistence.xml;
        java-->org; 
        org-->project;
        project-->App.java;
        project-->model;
        project-->controller;
        project-->view;
        model-->User.java;
        model-->Results.java;
        view-->UserSignUp.java
        view-->UserSignIn.java
        view-->QuizWelcomeHome.java
        view-->Rules.java;
        view-->Quiz.java;
        view-->Score.java;
        view-->ChangePassword.java
        controller-->SiginBtn.java;
        controller-->UserController.java;
        controller-->TripleDes.java;
        controller-->Validation.java;
        controller-->UserValidation.java;
        controller-->ChangePasswordBtn.java;
        
        
```
