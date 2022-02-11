package org.project.view;


import org.project.contoller.TripleDes;
import org.project.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import static org.project.contoller.UserController.findByEmail;

/**
 * 09/02/2022
 */


public class UserLogin extends JFrame {

    private JPanel contentPane;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private int xx,xy;

    public UserLogin() throws HeadlessException {
        setBackground(Color.WHITE);
        setBounds(100,100,650,443);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 308, 452);
        contentPane.add(panel);
        panel.setLayout(null);


        JLabel draggedLabel = new JLabel("");

        draggedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                xy = e.getY();
            }
        });
        draggedLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                int x = arg0.getXOnScreen();

                int y = arg0.getYOnScreen();

                UserLogin.this.setLocation(x - xx, y - xy);
            }
        });
        draggedLabel.setBounds(98, -12, 380, 292);
        panel.add(draggedLabel);
        draggedLabel.setIcon(new ImageIcon("src/main/java/org/project/icons/user2.png"));


        JLabel loginUi = new JLabel("Login UI");
        loginUi.setHorizontalAlignment(SwingConstants.CENTER);
        loginUi.setFont(new Font("Tahoma", Font.BOLD, 20));
        loginUi.setForeground(new Color(255, 255, 255));
        loginUi.setBounds(87, 310, 124, 25);
        panel.add(loginUi);


        Button login = new Button("Login");
        login.addActionListener(e -> {
            UserLogin.this.dispose();
            String email=emailTextField.getText();
            String password=new String(passwordField.getPassword());
            User user=findByEmail(email);
            TripleDes des=null;
            try {
                des=new TripleDes();
                final var decryptPassword = des.decrypt(user.getPassword());
                if (email.equals(user.getEmail())&& password.equals(decryptPassword)){
                    new QuizWelcomeHome(email).setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(250, 128, 114));
        login.setBounds(329, 300, 283, 35);
        contentPane.add(login);


        Button signUpBtn = new Button("Signup");
        signUpBtn.addActionListener(e -> {

            UserLogin.this.dispose();
            UserSignUp signUp1 = new UserSignUp();
            signUp1.setUndecorated(true);
            signUp1.setVisible(true);
        });
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(new Color(250, 128, 114));
        signUpBtn.setBounds(329, 360, 283, 35);
        contentPane.add(signUpBtn);


        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(329, 139, 283, 29);
        contentPane.add(emailTextField);


        JLabel message=new JLabel("");
        message.setBounds(310,40,400,34);
        message.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(message);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setBounds(329, 114, 113, 14);
        contentPane.add(emailLabel);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(329, 184, 113, 14);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(329, 209, 283, 29);
        contentPane.add(passwordField);

        final JCheckBox checkBox=new JCheckBox("show password");
        checkBox.setBounds(329,241,238,29);
        checkBox.setBackground(Color.WHITE);
        contentPane.add(checkBox);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()){
                passwordField.setEchoChar((char)0);
            }else {
                passwordField.setEchoChar('*');
            }
        });



        JLabel forgotPassword=new JLabel("if you want to forget password");
        forgotPassword.setEnabled(false);
        forgotPassword.setBounds(329, 269, 283, 29);
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = JOptionPane.showInputDialog( "Provide us your  email:" );

                System.out.println(email);
                System.out.println("forgot password");
            }

        });
        contentPane.add(forgotPassword);


        JLabel crossXLabel = new JLabel("X");
        crossXLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);

            }
        });
        crossXLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        crossXLabel.setForeground(Color.RED);
        crossXLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        crossXLabel.setBounds(602, 0, 43, 25);
        contentPane.add(crossXLabel);







    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            try {
                UserLogin login=new UserLogin();
                login.setUndecorated(true);
                login.setVisible(true);
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }
}
