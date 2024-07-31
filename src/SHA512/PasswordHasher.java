package SHA512;

import java.security.SecureRandom;
import java.security.MessageDigest;

public class PasswordHasher {

    public static String[] hashPassword(String password) throws Exception {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        byte[] hashedPassword = md.digest(password.getBytes("UTF-8"));

        String saltString = new String(salt, "UTF-8");
        String hashedPasswordString = new String(hashedPassword, "UTF-8");

        return new String[]{hashedPasswordString, saltString};
    }

}