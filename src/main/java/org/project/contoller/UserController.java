package org.project.contoller;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.project.model.Results;
import org.project.model.User;

import java.util.List;


/**
 * 10/02/2022
 */


public class UserController {
    private static EntityManager entityManager = null;
    private static TripleDes des;

    public UserController() throws Exception {
        des = new TripleDes();
    }

    private static void beginQuery() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }


    public static boolean insertUser(User user) {
        beginQuery();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        System.out.println(user);
        return true;
    }

    public static String insertScore(Results results) {
        beginQuery();
        entityManager.persist(results);
        entityManager.getTransaction().commit();
        return "score inserted";
    }

    public static User findByEmail(final String email) {
        beginQuery();
        User user = entityManager.find(User.class, email);
        entityManager.getTransaction().commit();
        return user;
    }

    public static List<User> getAllUsers() {
        beginQuery();
        Query query = entityManager.createQuery("from User");
        List<User> users = (List<User>) query.getResultList();
        entityManager.getTransaction().commit();
        return users;
    }
}
