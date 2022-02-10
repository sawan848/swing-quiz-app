package org.project.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 10/02/2022
 */


public class Score extends JFrame implements ActionListener {
    private String username;

    public Score(final String username,final int score) {
        this.username=username;

        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setTitle(username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon("src/main/java/org/project/icons/score.png");
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 200, 300, 250);
        add(l1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l2 = new JLabel("Thankyou " + username + " for Playing Simple Minds");
        l2.setBounds(45, 30, 700, 30);
        l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        add(l2);

        JLabel l3 = new JLabel("Your Score is " + score);
        l3.setBounds(350, 200, 300, 30);
        l3.setFont(new Font("Jokerman", Font.PLAIN, 26));
        l3.setForeground(new Color(199, 21, 133));
        add(l3);

        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        b1.setBounds(400, 270, 120, 30);
        add(b1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new QuizWelcomeHome(username).setVisible(true);
    }

    public static void main(String[] args){
        new Score("", 0).setVisible(true);
    }
}
