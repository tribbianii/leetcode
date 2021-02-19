package leetcode;

import java.util.*;

public class TriePalindromePairs {
    static class TrieNode {
        Map<Character, TrieNode> nexts;
        int level;
        int endWordIndex;
        List<Integer> wordIndexes;
        TrieNode() {
            this.nexts = new HashMap<Character, TrieNode>();
            this.endWordIndex = -1;
            this.wordIndexes = new ArrayList<>();
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode leaf = new TrieNode();
        TrieNode forward = root;
        TrieNode backward = leaf;
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            if (word.length() != 0) {
                for (int j = 0; j < word.length(); j ++) {
                    char c = word.charAt(j);
                    char h = word.charAt(word.length() - 1 - j);
                    if (!forward.nexts.containsKey(c)) {
                        forward.nexts.put(c, new TrieNode());
                    }
                    forward = forward.nexts.get(c);
                    forward.level = j;
                    forward.wordIndexes.add(i);
                    if (!backward.nexts.containsKey(h)) {
                        backward.nexts.put(h, new TrieNode());
                    }
                    backward = backward.nexts.get(h);
                    backward.level = j;
                    backward.wordIndexes.add(i);
                }
                forward.endWordIndex = i;
                backward.endWordIndex = i;
            } else {
                for (int k = 0; k < words.length; k ++) {
                    if (k != i && isPalindrome(words[k], 0, words[k].length() - 1)) {
                        res.add(Arrays.asList(k, i));
                        res.add(Arrays.asList(i, k));
                    }
                }
            }
            forward = root;
            backward = leaf;
        }
        dfs(forward, backward, words, res);
        return res;
    }
    public void dfs(TrieNode forward, TrieNode backward, String[] words, List<List<Integer>> res) {
        if (forward.endWordIndex >= 0) {
            for (int backwardWordIndex : backward.wordIndexes) {
                if (isPalindrome(words[backwardWordIndex], 0, words[backwardWordIndex].length() - 2 - backward.level)) {
                    res.add(Arrays.asList(forward.endWordIndex, backwardWordIndex));
                }
            }
        }
        if (backward.endWordIndex >= 0) {
            for (int forwardWordIndex : forward.wordIndexes) {
                if (backward.endWordIndex != forwardWordIndex &&
                        isPalindrome(words[forwardWordIndex], forward.level + 1, words[forwardWordIndex].length() - 1)) {
                    res.add(Arrays.asList(forwardWordIndex, backward.endWordIndex));
                }
            }
        }
        if (forward.endWordIndex >= 0 && backward.endWordIndex >= 0) {
            if (forward.endWordIndex != backward.endWordIndex) {
                res.add(Arrays.asList(forward.endWordIndex, backward.endWordIndex));
            }
        }
        for (Character c : forward.nexts.keySet()) {
            if (backward.nexts.containsKey(c)) {
                dfs(forward.nexts.get(c), backward.nexts.get(c), words, res);
            }
        }
    }
    public boolean isPalindrome(String word, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return false;
        }
        while (leftIndex < rightIndex) {
            if (word.charAt(leftIndex ++) != word.charAt(rightIndex --)) {
                return false;
            }
        }
        return true;
    }
}
