
    
    package JavaLearnings;
    import edu.duke.*;
    import java.io.*;

    public class CaesarCipher {
    	
    	public String encrypt(String input, int key) {
    		StringBuilder encrypted = new StringBuilder(input);
    		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    		
    		for (int i = 0; i < encrypted.length(); i++) {
    			char currChar = encrypted.charAt(i);
    			char newChar;
    			
    			if (Character.isUpperCase(currChar)) {
    				int idx = alphabet.indexOf(currChar);
    				if (idx != -1) {
    					newChar = shiftedAlphabet.charAt(idx);
    					encrypted.setCharAt(i, newChar);
    				}
    			} else if (Character.isLowerCase(currChar)) {
    				currChar = Character.toUpperCase(currChar);
    				int idx = alphabet.indexOf(currChar);
    				if (idx != -1) {
    					newChar = shiftedAlphabet.charAt(idx);
    					encrypted.setCharAt(i, Character.toLowerCase(newChar));
    				}
    			}
    		}
    		return encrypted.toString();
    	}
    	
    	public void testCaesar() {
    		int key = 15;
    		FileResource fr = new FileResource();
    		String message = fr.asString();
    		String encrypted = encrypt(message, key);
    		System.out.println(encrypted);
    		String decrypted = encrypt(encrypted, 26 - key);
    		System.out.println(decrypted);
    	}
    	
    	public String encryptTwoKeys(String input, int key1, int key2) {
    		StringBuilder encrypted = new StringBuilder(input);
    		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    		String shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0, key1);
    		String shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    		
    		for (int i = 0; i < encrypted.length(); i++) {
    			char currChar = encrypted.charAt(i);
    			char newChar;
    			
    			if (Character.isUpperCase(currChar)) {
    				if (i % 2 == 0) {
    					int idx = alphabet.indexOf(currChar);
    					if (idx != -1) {
    						newChar = shiftedAlphabetKey1.charAt(idx);
    						encrypted.setCharAt(i, newChar);
    					}
    				} else {
    					int idx = alphabet.indexOf(currChar);
    					if (idx != -1) {
    						newChar = shiftedAlphabetKey2.charAt(idx);
    						encrypted.setCharAt(i, newChar);
    					}
    				}
    			} else if (Character.isLowerCase(currChar)) {
    				if (i % 2 == 0) {
    					currChar = Character.toUpperCase(currChar);
    					int idx = alphabet.indexOf(currChar);
    					if (idx != -1) {
    						newChar = shiftedAlphabetKey1.charAt(idx);
    						encrypted.setCharAt(i, Character.toLowerCase(newChar));
    					}
    				} else {
    					currChar = Character.toUpperCase(currChar);
    					int idx = alphabet.indexOf(currChar);
    					if (idx != -1) {
    						newChar = shiftedAlphabetKey2.charAt(idx);
    						encrypted.setCharAt(i, Character.toLowerCase(newChar));
    					}
    				}
    			}
    		}
    		return encrypted.toString();
    	}
    	
    	public void testencryptTwoKeys() {
    		String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
    		int key1 = 2;
    		int key2 = 20;
    		String encryptedTwoKeys = encryptTwoKeys(input, key1, key2);
    		System.out.println(encryptedTwoKeys);
    	}
    	
    	public static void main(String[] args) {
    		CaesarCipher obj1 = new CaesarCipher();
    		//obj1.testCaesar();
    		obj1.testencryptTwoKeys();
    		
    		    	}
    }

