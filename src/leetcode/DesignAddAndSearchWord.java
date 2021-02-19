package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWord {

    static class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> nexts;
        TrieNode() {
            this.isEnd = false;
            this.nexts = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public DesignAddAndSearchWord() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.nexts.containsKey(c)) {
                node.nexts.put(c, new TrieNode());
            }
            node = node.nexts.get(c);
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return dfsSearch(node, word, 0);
    }

    public boolean dfsSearch(TrieNode node, String word, int index) {
        if (index < word.length()) {
            char c = word.charAt(index);
            if (c == '.') {
                for (Character d : node.nexts.keySet()) {
                    if (dfsSearch(node.nexts.get(d), word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.nexts.containsKey(c)) {
                    return false;
                }
                return dfsSearch(node.nexts.get(c), word, index + 1);
            }
        } else {
            return node.isEnd;
        }
    }
}