package org.project.contoller;


import org.project.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.project.contoller.UserController.insertUser;

/**
 * 11/02/2022
 */


public class SignBtn implements ActionListener {
    private JLabel messageLabel;
    private User users;

    public SignBtn(User user, JLabel message) {
        this.users = user;
        this.messageLabel = message;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = users.getUsername();
        String userEmail = users.getEmail();
        String userPassword = users.getPassword();
        String userConfirmPassword = users.getConfirmPassword();
        Validation validation = new UserValidation();
        if (validation.isValidUsername(userName)) {
            users.setUsername(userName);
        } else {
            messageLabel.setText("Please enter a valid username");
        }
        if (validation.isValidEmail(userEmail)) {
            users.setEmail(userEmail);
        } else {
            messageLabel.setText("Please enter a valid email");
        }
        if (validation.isValidPassword(userPassword)) {
            if (userPassword.equals(userConfirmPassword)) {
                TripleDes des = null;
                try {
                    des = new TripleDes();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                users.setPassword(des.encrypt(userPassword));
                System.out.println("password " + userPassword);
            } else {
                messageLabel.setText("Please enter a valid password");
            }
        } else {
            messageLabel.setText("Please enter a valid password");
        }
        System.out.println(users);
        if (insertUser(users)) {

            messageLabel.setText("data inserted");
            System.out.println(users);
        } else {
            messageLabel.setText("getting error in inserting data");
        }

    }
}
