package JavaLearnings;
import java.util.Random;

import edu.duke.*;

public class CaesarBreaker {
    
    public int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] values) {
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);
        int key = maxIndex - 4; 
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return cc.encrypt(encrypted, 26 - key);
    }
    
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxIndex = maxIndex(freqs);
        int key = maxIndex - 4; 
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return key;
    }
    
    public void decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        System.out.println("Keys found: " + key1 + ", " + key2);
        String decrypted = cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
        System.out.println("Decrypted message: " + decrypted);
    }
    
    public void testDecrypt() {
        FileResource resource = new FileResource(); 
        String encrypted = resource.asString().trim();
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted message: " + decrypted);
    }
    
    public static void main(String[] args) {
        CaesarBreaker obj1 = new CaesarBreaker();
        obj1.decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
    }
}

