package leetcode;

import java.util.*;

public class StringMostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned) {
            bannedWords.add(word);
        }
        Map<String, Integer> wordCount = new HashMap();
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        Map.Entry<String, Integer> res = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            if (entry.getValue() > max) {
                res = entry;
            }
        }

        return res.getKey();
    }
}
