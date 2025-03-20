package org.howard.edu.lsp.midterm.question4;
import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private String sentence;
    
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }
    
    // Find all words that have the max length in the sentence
    public List<String> findLongestWords() {
        List<String> result = new ArrayList<>();
        
        // Handle empty input
        if (sentence == null || sentence.trim().isEmpty()) {
            return result;
        }
        
        String[] words = sentence.trim().split("\\s+");
        int maxLen = 0;
        
        // First pass - find max length
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        
        // Second pass - collect words with max length
        for (String word : words) {
            if (word.length() == maxLen) {
                result.add(word);
            }
        }
        
        return result;
    }
}