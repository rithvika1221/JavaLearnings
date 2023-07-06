package JavaLearnings;
import java.util.Random;

import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int length = getWordLength(word);
            if (length >= counts.length) {
                length = counts.length - 1;
            }
            counts[length]++;
        }
    }

    private int getWordLength(String word) {
        int length = word.length();
        if (length > 0 && Character.isLetter(word.charAt(0)) && Character.isLetter(word.charAt(length - 1))) {
            return length;
        }
        if (length > 0 && !Character.isLetter(word.charAt(0))) {
            length--;
        }
        if (length > 0 && !Character.isLetter(word.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    public void testCountWordLengths() {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println("Words of length " + i + ": " + counts[i]);
            }
        }
        int mostCommonLength = indexOfMax(counts);
        System.out.println("Most common word length: " + mostCommonLength);
    }

    private int indexOfMax(int[] values) {
        int maxIndex = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();
    }
}