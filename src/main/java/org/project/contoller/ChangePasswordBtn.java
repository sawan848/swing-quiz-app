package org.project.contoller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 12/02/2022
 */


public class ChangePasswordBtn implements ActionListener {
    private final JPasswordField localPassword;
    private final JPasswordField confirmPassword;
    private final Validation validation;
    private JLabel message;

    public ChangePasswordBtn(JPasswordField localPassword, JPasswordField confirmPassword, JLabel message) {
        this.localPassword=localPassword;
        this.confirmPassword=confirmPassword;
        this.message=message;
        validation=new UserValidation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (validation.isValidEmail(new String(localPassword.getPassword()))){

            if (new String(localPassword.getPassword()).equals(new String(confirmPassword.getPassword()))){

                message.setText("Password Successfully changed");
                message.setForeground(Color.green);
                System.out.println("password = " + new String(localPassword.getPassword()));
            }else {
                message.setText("please enter a valid password ");
                message.setForeground(Color.RED);
            }
        }else {
            message.setText("please enter a valid password ");
            message.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null ,"Please enter a valid password","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
