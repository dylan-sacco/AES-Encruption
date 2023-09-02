import DylanEncryption.Encryption;

public class JavaEncryption {
    public static void main(String[] args) {
        String secretKey = "ThisIsASecretKey";
        String TextToEncrypt = "Hello, World!  random text to encrypt. 1234567890-=!@#$%^&*()_+";
        
        System.out.println(TextToEncrypt.length());
        byte[] encyptedBytes = Encryption.encrypt(TextToEncrypt, secretKey);

        System.out.println(new String(encyptedBytes) );
        System.out.println(Encryption.decrypt(encyptedBytes, secretKey));
    }
}
