import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // create secret key using AES
        String secretKey = "ThisIsASecretKey";
        Key key = new SecretKeySpec(secretKey.getBytes(), "AES");
        
        // create cipher object
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // encrypt the plain text
        String plainText = "Hello, World! (Encrypted)";
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // System.out.println(encryptedBytes);

        // decrypt the encrypted text
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        String decryptedText = new String(decryptedBytes);

        System.out.println("Original: " + plainText);
        System.out.println("Encrypted: " + new String(encryptedBytes));
        System.out.println("Decrypted: " + decryptedText);
    }
}
