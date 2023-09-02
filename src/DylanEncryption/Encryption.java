package DylanEncryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Encryption {
    private static Cipher cipher;
    private static Key key;

    public static final int decrypt = Cipher.DECRYPT_MODE;
    public static final int encrypt = Cipher.ENCRYPT_MODE;

    /**
     * Basic encryption With ECB/PKCS5Padding with a secret key
     *
     * @param plainText
     * @param secretKey
     * @return byte[]
     */
    public static byte[] encrypt(String plainText, String secretKey) {
        return encrypt(plainText, secretKey, "AES/ECB/PKCS5Padding");
    }

    public static byte[] encrypt(String plainText, String secretKey, String algorithm) {
        try {
            setKey(secretKey);
            setCipher(encrypt, algorithm);
            return cipher.doFinal(plainText.getBytes());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return new byte[0];
    }

    public static String decrypt(byte[] encryptedText, String secretKey) {
        return decrypt(encryptedText, secretKey, "AES/ECB/PKCS5Padding");
    }

    public static String decrypt(byte[] encryptedText, String secretKey, String algorithm) {
        try {
            setKey(secretKey);
            setCipher(decrypt, algorithm);
            return new String(cipher.doFinal(encryptedText));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return "";
    }

    private static void setKey(String secretKey) {
        key = new SecretKeySpec(secretKey.getBytes(), "AES");
    }

    private static void setCipher(int mode, String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
            cipher.init(mode, key);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public static SecretKey generateAESKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public static String secretKeyToHex(SecretKey key) {
        byte[] keyBytes = key.getEncoded();
        StringBuilder hexString = new StringBuilder();

        for (byte keyByte : keyBytes) {
            // Convert each byte to a 2-character hexadecimal representation
            String hex = Integer.toHexString(0xFF & keyByte);
            if (hex.length() == 1) {
                // If the hexadecimal string is a single character, prepend a '0' to make it two characters
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
