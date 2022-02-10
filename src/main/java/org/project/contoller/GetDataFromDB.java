package org.project.contoller;


import org.project.model.User;

/**
 * 10/02/2022
 */


public class GetDataFromDB {
    public static void main(String[] args) throws Exception {
        User user=new User();
        user.setPassword("hello");
        TripleDes des=new TripleDes();
        user.setPassword(des.encrypt(user.getPassword()));
        System.out.println(user);
    }
}
