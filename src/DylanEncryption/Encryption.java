package DylanEncryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Encryption {
    // static private String secretKey;
    static private Key key;
    static private Cipher cipher;
    static public final int decrypt = Cipher.DECRYPT_MODE;
    static public final int encrypt = Cipher.ENCRYPT_MODE;
    
    /**
     * basic encryption With ECB/PKCS5Padding with a secret key
     * @param plainText
     * @param secretKey
     * @return String
     */
    public static byte[] encrypt(String plainText, String secretKey) {
        // uses the default encryption mode
        return encrypt(plainText, secretKey, "AES/ECB/PKCS5Padding");
    }
    public static byte[] encrypt(String plainText, String secretKey , String algorithm) {
        // setKey(secretKey);
        // setCipher(encrypt);
        try {
            key = new SecretKeySpec(secretKey.getBytes(), "AES");
            cipher = Cipher.getInstance(algorithm);
            cipher.init(encrypt, key);
            return cipher.doFinal(plainText.getBytes());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return new byte[0];
    }
    
    public static String decrypt(byte[] encryptedText, String secretKey) {
        return decrypt(encryptedText, secretKey, "AES/ECB/PKCS5Padding");
    }
    public static String decrypt(byte[] encryptedText, String secretKey, String algorithm) {
        // setKey(secretKey);
        // setCipher(decrypt);
        try {
            key = new SecretKeySpec(secretKey.getBytes(), "AES");
            cipher = Cipher.getInstance(algorithm);
            cipher.init(decrypt, key);
            return new String(cipher.doFinal(encryptedText));
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return "";
    }
    private static void setKey(String secretKey){
        key = new SecretKeySpec(secretKey.getBytes(), "AES");
    }
    private static void setCipher(int mode){
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(mode, key);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
    
}
