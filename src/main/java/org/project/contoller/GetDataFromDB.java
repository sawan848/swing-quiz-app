package org.project.contoller;


import org.project.model.User;

import static org.project.contoller.UserController.findByEmail;

/**
 * 10/02/2022
 */


public class GetDataFromDB {
    public static void main(String[] args) throws Exception {
        User user=new User();
        User byEmail = findByEmail("radhemohan@gmail.com");
        user.setPassword("hello");
        TripleDes des=new TripleDes();
        String encrypt = des.decrypt(byEmail.getPassword());
        System.out.println(user+"\n"+byEmail+"\n"+encrypt);
    }
}
