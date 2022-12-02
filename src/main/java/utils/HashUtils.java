package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashUtils {

    private HashUtils() {
        // no instance
    }

    public static String md5(String input) {
        try {
            return new BigInteger(1, MessageDigest.getInstance("MD5").digest(input.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            // should never happen, as "MD5" is hard coded and included in the standard JDK and JRE
            throw new RuntimeException(e);
        }
    }

}
