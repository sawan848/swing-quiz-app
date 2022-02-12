package org.project.contoller;


import static org.project.contoller.UserController.getAllUsers;

/**
 * 10/02/2022
 */


public class GetDataFromDB {
    public static void main(String[] args) throws Exception {
        System.out.println(" = " + getAllUsers());
//        User user=new User();
//        User byEmail = findByEmail("radhemohan@gmail.com");
//        user.setPassword("hello");
//        TripleDes des=new TripleDes();
//        String encrypt = des.decrypt(byEmail.getPassword());
//        System.out.println(user+"\n"+byEmail+"\n"+encrypt);
    }
}
