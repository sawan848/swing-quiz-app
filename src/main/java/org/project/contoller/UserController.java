package org.project.contoller;


import jakarta.persistence.*;
import org.project.model.*;


/**
 * 10/02/2022
 */


public class UserController {
    private static EntityManager entityManager=null;
    private static TripleDes des;

    public UserController() throws Exception {
        des=new TripleDes();
    }

    private static void beginQuery(){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("pu");
        entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }
    private static boolean userValidation(User user){

        try {
            Validation validation=new UserValidation();
            if (validation.isValidUsername(user.getUsername())){
                user.setUsername(user.getUsername());
            }else if (validation.isValidPassword(user.getPassword())
                    && validation.isValidPassword(user.getConfirmPassword())  ){
                System.out.println("password :\t"+des.encrypt(user.getPassword()));
                String password=des.encrypt(user.getPassword());
                user.setPassword(password);
            }else  if (validation.isValidEmail(user.getEmail())){
                user.setEmail(user.getEmail());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }
    public static boolean insertUser(User user){
        beginQuery();
        if (userValidation(user))entityManager.persist(user);
        entityManager.getTransaction().commit();
        return true;
    }
    public static String insertScore(Results results){
        beginQuery();
        entityManager.persist(results);
        entityManager.getTransaction().commit();
        return "score inserted";
    }

    public static User findByEmail(final String email){
        beginQuery();
        User user=entityManager.find(User.class,email);
        entityManager.getTransaction().commit();
        return user;
    }
}
