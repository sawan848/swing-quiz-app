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

    public static boolean insertUser(User user){
        beginQuery();
            entityManager.persist(user);
        entityManager.getTransaction().commit();

        System.out.println(user);
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
