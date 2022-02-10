package org.project.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 10/02/2022
 */


public class Rules extends JFrame implements ActionListener {

    private JButton backBtn, startBtn;
    private String username;

    public Rules(final String email) {
        this.username = username;
        setBounds(600, 200, 800, 650);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setForeground(Color.GRAY);
        setLayout(null);


        JLabel welcomeLabel = new JLabel("Welcome " + username + " to Simple Minds");
        welcomeLabel.setForeground(new Color(30, 144, 255));
        welcomeLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        welcomeLabel.setBounds(50, 20, 700, 30);
        add(welcomeLabel);



        JLabel noticeLabel = new JLabel("");
        noticeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        noticeLabel.setBounds(20, 90, 600, 350);
        noticeLabel.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>"
        );
        add(noticeLabel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backBtn = new JButton("Back");
        backBtn.setBounds(250, 500, 100, 30);
        backBtn.setBackground(new Color(30, 144, 255));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        startBtn = new JButton("Start");
        startBtn.setBounds(400, 500, 100, 30);
        startBtn.setBackground(new Color(30, 144, 255));
        startBtn.setForeground(Color.WHITE);
        startBtn.addActionListener(this);
        add(startBtn);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            dispose();
            this.setVisible(false);
            new QuizWelcomeHome(username).setVisible(true);
        }else if(ae.getSource() == startBtn){
            this.setVisible(false);

            Quiz quiz=new Quiz(username);
            quiz.setTitle(username);
            quiz.setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new Rules("");
    }
}
