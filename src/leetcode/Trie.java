package leetcode;

import java.util.HashMap;
import java.util.Map;

class Trie {

    static class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap;

        TrieNode() {
            this.childrenMap = new HashMap<Character, TrieNode>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(!curr.childrenMap.containsKey(c)) {
                // insert a new node if the path does not exist
                curr.childrenMap.put(c, new TrieNode());
            }
            curr = curr.childrenMap.get(c);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(!curr.childrenMap.containsKey(c)) {
                return false;
            }
            curr = curr.childrenMap.get(c);
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(!curr.childrenMap.containsKey(c)) {
                return false;
            }
            curr = curr.childrenMap.get(c);
        }
        return true;
    }
}