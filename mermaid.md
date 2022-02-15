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
        project-->Controller;
        project-->View;
        Controller-->Sigin.java;
        Controller-->TripleDes.java
        Controller-->Validation.java
        
```
