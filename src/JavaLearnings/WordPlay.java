package JavaLearnings;
import edu.duke.*;
import java.io.*;

public class WordPlay {

    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); 
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
           return true;
        } else {
           return false;
        }    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder replaced = new StringBuilder(phrase);
        for (int i = 0; i < replaced.length(); i++) {
            if (isVowel(replaced.charAt(i))) {
                replaced.setCharAt(i, ch);
            }
        }
        return replaced.toString();
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder emphasized = new StringBuilder(phrase);
        for (int i = 0; i < emphasized.length(); i++) {
            if (Character.toLowerCase(emphasized.charAt(i)) == Character.toLowerCase(ch)) {
                if (i % 2 == 0) { 
                    emphasized.setCharAt(i, '*');
                } else {
                    emphasized.setCharAt(i, '+');
                }
            }
        }
        return emphasized.toString();
    }

    public static void main(String[] args) {
        WordPlay obj1 = new WordPlay();

        System.out.println(obj1.isVowel('F')); 
        System.out.println(obj1.isVowel('a')); 

        System.out.println(obj1.replaceVowels("Hello World", '*')); 

        System.out.println(obj1.emphasize("dna ctgaaactga", 'a'));
        System.out.println(obj1.emphasize("Mary Bella Abracadabra", 'a')); 
    }
}

