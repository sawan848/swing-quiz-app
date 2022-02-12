package org.project;

import org.project.view.UserSignUp;

import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserSignUp userSignUp = new UserSignUp();
                userSignUp.setUndecorated(true);
                userSignUp.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}
