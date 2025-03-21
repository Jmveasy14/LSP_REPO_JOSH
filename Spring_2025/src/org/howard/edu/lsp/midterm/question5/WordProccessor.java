package org.howard.edu.lsp.midterm.question4;
import java.util.List;

public class WordProcessorDriver {
    public static void main(String[] args) {
        // Tests with a sentence having one longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results, amazing achievements!");
        List<String> longest1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longest1);  
        
        // Test with powerful repeated
        WordProcessor wp2 = new WordProcessor("Java is a powerful tool!");
        List<String> longest2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longest2);  
        
        // Test with single-letter words
        WordProcessor wp3 = new WordProcessor("A B C D E");
        List<String> longest3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longest3);  
        
        // Test with empty input
        WordProcessor wp4 = new WordProcessor("");
        List<String> longest4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longest4);  
    }
}


