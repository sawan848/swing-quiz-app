package org.project.contoller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 10/02/2022
 */


public class UserValidation implements Validation {
    /**
     * @param name
     * @return name
     */
    @Override
    public boolean isValidName(String name) {
        boolean result = false;
        if (name.length() > 4) {
            String regex = "^[A-Za-z ]+$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            result = matcher.find();
        }
        return result;
    }

    /**
     * @param username
     * @return username
     */
    @Override
    public boolean isValidUsername(String username) {
        final String regularExpression = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        return username.matches(regularExpression);
    }

    /**
     * @param email
     * @return true
     */
    @Override
    public boolean isValidEmail(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile(
                "[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                        "(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                        "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+" +
                        "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

        if ((email.endsWith("com") || email.endsWith("org") || email.endsWith("edu")) &&
                (email.contains("gmail") || email.contains("github")
                        || email.contains("docker") || email.contains("yahoo")) || email.contains("apple")
        ) {
            return EMAIL_REGEX.matcher(email).matches();

        }
        return false;
    }

    /**
     * @param password
     * @return true
     */
    @Override
    public boolean isValidPassword(String password) {
        String exp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(exp);
    }
}
