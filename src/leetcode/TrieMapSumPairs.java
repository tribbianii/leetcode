package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    MapSum() Initializes the MapSum object.
    void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
    int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix
*/
public class TrieMapSumPairs {
    static class TrieNode {
        public int val;
        public Map<Character, TrieNode> children;
        public TrieNode() {
            this.val = 0;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode root;

    public TrieMapSumPairs() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
        }
        return sumFrom(node);
    }

    public int sumFrom(TrieNode node) {
        int sum = node.val;
        for (char c : node.children.keySet()) {
            sum += sumFrom(node.children.get(c));
        }
        return sum;
    }
}
