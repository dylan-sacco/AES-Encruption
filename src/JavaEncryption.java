import javax.crypto.SecretKey;

import DylanEncryption.Encryption;

public class JavaEncryption {
    public static void main(String[] args) {

        String TextToEncrypt = "Hello, World!  random text to encrypt. 1234567890-=!@#$%^&*()_+";
        SecretKey key = Encryption.generateAESKey();

        System.out.println("Key: " + Encryption.secretKeyToHex(key));
        
        byte[] encyptedBytes = Encryption.encrypt(TextToEncrypt, Encryption.secretKeyToHex(key));

        System.out.println("Encryped: " + new String(encyptedBytes) );
        System.out.println("Decrypted: " + Encryption.decrypt(encyptedBytes, Encryption.secretKeyToHex(key)));
    }
}
