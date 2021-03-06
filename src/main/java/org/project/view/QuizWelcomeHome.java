package org.project.view;


import org.project.contoller.UserValidation;
import org.project.contoller.Validation;
import org.project.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import static org.project.contoller.UserController.findByEmail;
import static org.project.contoller.UserController.getAllUsers;

/**
 * 10/02/2022
 */


public class QuizWelcomeHome extends JFrame {
    private JButton rulesBtn, exitBtn;
    private JTextField emailTextField;
    private JLabel message;
    private final String email;

    public QuizWelcomeHome(final String email) {
        this.email = email;
        setBounds(400, 200, 1200, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle(email);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("src/main/java/org/project/icons/login.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, -12, 600, 500);
        add(imageLabel);

        message = new JLabel("");
        message.setBounds(735, 300, 444, 55);
        message.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        add(message);

        JLabel welcomeToQuiz = new JLabel("Welcome To Quiz ");
        welcomeToQuiz.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        welcomeToQuiz.setForeground(new Color(30, 144, 254));
        welcomeToQuiz.setBounds(750, 60, 400, 45);
        add(welcomeToQuiz);


        JLabel emailLabel = new JLabel("Enter Your Email");
        emailLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        emailLabel.setForeground(new Color(30, 144, 254));
        emailLabel.setBounds(810, 150, 300, 20);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(735, 200, 300, 25);
        emailTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(emailTextField);

        rulesBtn = new JButton("Rules");
        rulesBtn.setBounds(735, 270, 120, 25);
        rulesBtn.setBackground(new Color(30, 144, 254));
        rulesBtn.setForeground(Color.WHITE);

        add(rulesBtn);
        rulesBtn.addActionListener(e -> {
            String userEmail = emailTextField.getText();
            List<User> allUser = getAllUsers();
            final var stringStream = allUser.stream().map(User::getEmail);
            final var collect = allUser.stream().
                    map(User::toString).
                    filter(user -> user.contains(userEmail)).
                    collect(Collectors.toList());
            final var collect1 = stringStream.
                    filter(s -> userEmail.contains(s))
                    .collect(Collectors.toList());
            Validation validation = new UserValidation();
            if (collect1.contains(userEmail) && validation.isValidEmail(userEmail)) {
                String userName = findByEmail(userEmail).getUsername();
                System.out.println("userName = " + userName);
                dispose();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Rules rules = new Rules(userName);
                rules.setVisible(true);
                rules.setTitle(email);
            }else {
                message.setText("email not contains in the data base");
                message.setForeground(Color.RED);
            }
        });


        exitBtn = new JButton("Exit");
        exitBtn.setBounds(915, 270, 120, 25);
        exitBtn.setBackground(new Color(30, 144, 254));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

//    public static void main(String[] args) {
//        new QuizWelcomeHome("maghra@gmail.com");
//    }
}
