package org.java.project.view;


import org.java.project.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * 09/02/2022
 */


public class UserSignUp extends JFrame {
    private final JTextField userNameTextField;
    private final JTextField userEmailTextField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JCheckBox checkBox;
    private int  xx,xy;


    /**
     * Create the frame
     */
    public UserSignUp() throws HeadlessException {
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,650,550);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        JLabel message =new JLabel("");
        message.setFont(new Font("Tahoma",Font.BOLD,20));
        JPanel panel=new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,308,600);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel crossLabel=new JLabel("");
        crossLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx=e.getX();
                xy=e.getY();
            }
        });
        crossLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x=e.getXOnScreen();
                int y=e.getYOnScreen();
                UserSignUp.this.setLocation(x-xx,y-xy);
            }
        });
        crossLabel.setBounds(98,-12,380,292);
        panel.add(crossLabel);
        crossLabel.setIcon(new ImageIcon("src/main/java/org/project/icons/user2.png"));

        JLabel loginUI=new JLabel("SignUp UI");
        loginUI.setHorizontalAlignment(SwingConstants.CENTER);
        loginUI.setFont(new Font("Tahoma",Font.BOLD,20));
        loginUI.setForeground(new Color(255,255,255));
        loginUI.setBounds(87,310,124,25);
        panel.add(loginUI);

        JLabel welcomeLabel = new JLabel("Welcomes You");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        welcomeLabel.setBounds(87, 346, 124, 25);
        panel.add(welcomeLabel);

        checkBox=new JCheckBox("click me if you want to register");
        checkBox.setBounds(329, 355, 283, 35);
        checkBox.setBackground(Color.WHITE);




        final Button signUpBtn = new Button("SignUp");



        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(new Color(250, 128, 114));
        signUpBtn.setBounds(329, 391, 283, 35);
        contentPane.add(signUpBtn);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()){
                    signUpBtn.addActionListener(e1 -> {

                        User user=new User();
                        user.setUserType("ADMIN");

                        user.setUsername(userNameTextField.getText());
                        user.setEmail(userEmailTextField.getText());
                        user.setPassword(new String(passwordField.getPassword()));
                        user.setConfirmPassword(new String(confirmPasswordField.getPassword()));

                        userNameTextField.setText(" ");
                        userEmailTextField.setText(" ");
                        passwordField.setText("");
                        confirmPasswordField.setText("");
                        checkBox.setSelected(false);
                        System.out.println(user);
                    });
                }
            }
        });



        contentPane.add(checkBox);
        Button loginBtn = new Button("Login");

        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new Color(250, 128, 114));
        loginBtn.setBounds(329, 440, 283, 35);
        contentPane.add(loginBtn);

        loginBtn.addActionListener(e -> {
            dispose();
            UserLogin userLogin=new UserLogin();
            userLogin.setUndecorated(true);
            userLogin.setVisible(true);
        });


        Button resetBtn = new Button("Reset");
        resetBtn.addActionListener(e -> {
            userNameTextField.setText(" ");
            userEmailTextField.setText(" ");
            passwordField.setText("");
            confirmPasswordField.setText("");
            checkBox.setSelected(false);
        });

        resetBtn.setForeground(Color.WHITE);
        resetBtn.setBackground(new Color(250, 128, 114));
        resetBtn.setBounds(329, 490, 283, 35);
        contentPane.add(resetBtn);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(329, 67, 283, 29);
        contentPane.add(userNameTextField);
        userNameTextField.setColumns(10);

//        System.out.println(textField.getText());
        userEmailTextField = new JTextField();
        userEmailTextField.setColumns(10);
        userEmailTextField.setBounds(329, 139, 283, 29);
        contentPane.add(userEmailTextField);

        message.setBounds(310,40,400,34);
        message.setForeground(Color.RED);
        contentPane.add(message);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setBounds(329, 40, 113, 14);
        contentPane.add(lblUsername);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(329, 114, 113, 14);
        contentPane.add(lblEmail);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(329, 184, 113, 14);
        contentPane.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
        lblConfirmPassword.setBounds(329, 255, 199, 14);
        contentPane.add(lblConfirmPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(329, 209, 283, 29);
        contentPane.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(329, 280, 283, 29);
        contentPane.add(confirmPasswordField);

        final JCheckBox checkBox=new JCheckBox("show password");
        checkBox.setBounds(329,315,238,29);
        checkBox.setBackground(Color.WHITE);
        contentPane.add(checkBox);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()){
                passwordField.setEchoChar((char)0);
            }else {
                passwordField.setEchoChar('*');
            }
        });




        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);

            }
        });
        lblX.setHorizontalAlignment(SwingConstants.RIGHT);
        lblX.setForeground(Color.RED);
        lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblX.setBounds(602, 0, 43, 25);
        contentPane.add(lblX);


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {

                UserSignUp userSignUp=new UserSignUp();
                userSignUp.setUndecorated(true);
                userSignUp.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
