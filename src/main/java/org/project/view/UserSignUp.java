package org.project.view;


import org.project.contoller.SignBtn;
import org.project.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import static org.project.contoller.UserController.insertUser;


public class UserSignUp extends JFrame  {

    private JPanel contentPane;
    private JTextField userNameTextField;
    private JTextField userEmailTextField;
    private JPasswordField localPasswordField;
    private JPasswordField confirmPasswordField;



    private final JCheckBox checkBox;
    int xx,xy;

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

    /**
     * Create the frame.
     */
    public UserSignUp() {
//        setUndecorated(true);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 550);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel message=new JLabel("");
        message.setFont(new Font("Tahoma", Font.BOLD, 20));
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 308, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel movePanelLabel = new JLabel("");

        movePanelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                xy = e.getY();
            }
        });
        movePanelLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                int x = arg0.getXOnScreen();

                int y = arg0.getYOnScreen();

                UserSignUp.this.setLocation(x - xx, y - xy);
            }
        });
        movePanelLabel.setBounds(98, -12, 380, 292);
        panel.add(movePanelLabel);

        movePanelLabel.setIcon(new ImageIcon("src/main/java/org/project/icons/user2.png"));
        JLabel signUpUi = new JLabel("SignUp UI");
        signUpUi.setHorizontalAlignment(SwingConstants.CENTER);
        signUpUi.setFont(new Font("Tahoma", Font.BOLD, 20));
        signUpUi.setForeground(new Color(255, 255, 255));
        signUpUi.setBounds(87, 310, 124, 25);
        panel.add(signUpUi);

        JLabel welcomesYou = new JLabel("Welcomes You");
        welcomesYou.setHorizontalAlignment(SwingConstants.CENTER);
        welcomesYou.setForeground(Color.WHITE);
        welcomesYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
        welcomesYou.setBounds(87, 346, 124, 25);
        panel.add(welcomesYou);
        checkBox=new JCheckBox("click me if you want to register");
        checkBox.setBounds(329, 355, 283, 35);
        checkBox.setBackground(Color.WHITE);



        final Button signUpBtn = new Button("SignUp");



        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(new Color(250, 128, 114));
        signUpBtn.setBounds(329, 391, 283, 35);
        contentPane.add(signUpBtn);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()){
                    User user=new User();

                    user.setUsername(userNameTextField.getText());
                    user.setEmail(userEmailTextField.getText());
                    user.setPassword(new String(localPasswordField.getPassword()));
                    user.setConfirmPassword(new String(confirmPasswordField.getPassword()));
                    SignBtn signBtn=new SignBtn(user,message);
                    signUpBtn.addActionListener(signBtn);
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
        resetBtn.addActionListener(e-> {
                userEmailTextField.setText(" ");
                userNameTextField.setText(" ");
                localPasswordField.setText("");
                confirmPasswordField.setText("");
                message.setText(" ");
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
        userEmailTextField = new JTextField();
        userEmailTextField.setColumns(10);
        userEmailTextField.setBounds(329, 139, 283, 29);
        contentPane.add(userEmailTextField);

        message.setBounds(420,20,400,34);
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

        localPasswordField = new JPasswordField();
        localPasswordField.setBounds(329, 209, 283, 29);
        contentPane.add(localPasswordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(329, 280, 283, 29);
        contentPane.add(confirmPasswordField);

        final JCheckBox checkBox=new JCheckBox("show password");
        checkBox.setBounds(329,315,238,29);
        checkBox.setBackground(Color.WHITE);
        contentPane.add(checkBox);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()){
                localPasswordField.setEchoChar((char)0);
            }else {
                localPasswordField.setEchoChar('*');
            }
        });





        JLabel crossLabel = new JLabel("X");
        crossLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);

            }
        });
        crossLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        crossLabel.setForeground(Color.RED);
        crossLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        crossLabel.setBounds(602, 0, 43, 25);
        contentPane.add(crossLabel);


    }

}
