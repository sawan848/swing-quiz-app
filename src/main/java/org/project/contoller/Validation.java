package org.project.contoller;


/**
 * 10/02/2022
 */


public interface Validation {

    /**
     * @param name
     * @return
     */
    boolean isValidName(String name);
    /**
     * @param username
     * @return
     */
    boolean isValidUsername(String username);

    /**
     * @param email
     * @return
     */
    boolean isValidEmail(String email);

    /**
     * @param password
     * @return
     */
    boolean isValidPassword(String password);
}
