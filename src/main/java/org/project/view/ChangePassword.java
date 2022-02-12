package org.project.view;


import org.project.contoller.ChangePasswordBtn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * 12/02/2022
 */


public class ChangePassword extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel message;
    private int xx,xy;

    public ChangePassword() throws HeadlessException {

        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 443);
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


        JLabel lblNewLabel = new JLabel("");

        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                xy = e.getY();
            }
        });
        lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                int x = arg0.getXOnScreen();

                int y = arg0.getYOnScreen();

                ChangePassword.this.setLocation(x - xx, y - xy);
            }
        });
        lblNewLabel.setBounds(98, -12, 380, 292);
        panel.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("src/main/java/org/project/icons/user2.png"));


        JLabel lblLoginUi = new JLabel("Change Password");
        lblLoginUi.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginUi.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblLoginUi.setForeground(new Color(255, 255, 255));
        lblLoginUi.setBounds(58, 310, 222, 25);
        panel.add(lblLoginUi);


        JLabel welcomesYou = new JLabel("Welcomes You");
        welcomesYou.setHorizontalAlignment(SwingConstants.CENTER);
        welcomesYou.setForeground(Color.WHITE);
        welcomesYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
        welcomesYou.setBounds(58, 346, 184, 25);
        panel.add(welcomesYou);

        Button changePassword= new Button("Change Password");
        changePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        changePassword.setForeground(Color.WHITE);
        changePassword.setBackground(new Color(250, 128, 114));
        changePassword.setBounds(329, 280, 283, 29);
        contentPane.add(changePassword);

        message=new JLabel();
        message.setBounds(310,40,400,34);
        message.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(message);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(329, 114, 113, 14);
        contentPane.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
        lblConfirmPassword.setBounds(329, 184, 163, 14);
        contentPane.add(lblConfirmPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(329, 139, 283, 29);
        contentPane.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(329, 209, 283, 29);
        contentPane.add(confirmPasswordField);
        ChangePasswordBtn changePasswordBtn=new ChangePasswordBtn(passwordField, confirmPasswordField,message);

        changePassword.addActionListener(changePasswordBtn);

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
        EventQueue.invokeLater(()->{
            try {
                ChangePassword changePassword=new ChangePassword();
                changePassword.setUndecorated(true);
                changePassword.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
