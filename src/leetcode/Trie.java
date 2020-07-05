package leetcode;

class Trie {

    class TrieNode {
        
        TrieNode[] links;
        boolean isEnd;

        TrieNode() {
            this.links = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.links[c - 'a'] == null) {
                node.links[c - 'a'] = new TrieNode();
            }
            node = node.links[c - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.links[c - 'a'] == null) {
                return false;
            }
            node = node.links[c - 'a'];
        }
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.links[c - 'a'] == null) {
                return false;
            }
            node = node.links[c - 'a'];
        }
        return node != null;
    }
}