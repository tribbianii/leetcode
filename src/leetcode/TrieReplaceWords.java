package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieReplaceWords {
    static class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> nexts;
        TrieNode() {
            this.isEnd = false;
            this.nexts = new HashMap<Character, TrieNode>();
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for (String prefix : dict) {
            for (char c : prefix.toCharArray()) {
                if (!node.nexts.containsKey(c)) {
                    node.nexts.put(c, new TrieNode());
                }
                node = node.nexts.get(c);
            }
            node.isEnd = true;
            node = root;
        }
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            boolean foundPrefix = false;
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (!node.nexts.containsKey(c)) {
                    break;
                }
                prefix.append(c);
                if (node.nexts.get(c).isEnd) {
                    res.append(new String(prefix));
                    foundPrefix = true;
                    break;
                }
                node = node.nexts.get(c);
            }
            if (!foundPrefix) {
                res.append(word);
            }
            res.append(" ");
            node = root;
        }
        res.delete(res.length() - 1, res.length());
        return new String(res);
    }
}
