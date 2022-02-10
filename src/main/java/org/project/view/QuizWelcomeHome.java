package org.project.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 10/02/2022
 */


public class QuizWelcomeHome extends JFrame {
    private JButton rulesBtn, exitBtn;
    private JTextField emailTextField;
    private JLabel message;
    private String email;

    public QuizWelcomeHome(final String email) {
        this.email=email;
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

        message=new JLabel("");
        message.setBounds(735,300,444,55);
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
            dispose();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Rules rules=new Rules(email);
            rules.setVisible(true);
            rules.setTitle(email);
        });


        exitBtn = new JButton("Exit");
        exitBtn.setBounds(915, 270, 120, 25);
        exitBtn.setBackground(new Color(30, 144, 254));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitBtn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        new QuizWelcomeHome("maghra@gmail.com");
    }
}
