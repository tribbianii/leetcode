package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieWordSquares {
    static class TrieNode {
        Map<Character, TrieNode> nexts;
        List<Integer> wordsIndexes;
        TrieNode() {
            this.nexts = new HashMap<Character, TrieNode>();
            this.wordsIndexes = new ArrayList<>();
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for (int i = 0; i < words.length; i ++) {
            node = root;
            for (char c : words[i].toCharArray()) {
                if (!node.nexts.containsKey(c)) {
                    node.nexts.put(c, new TrieNode());
                }
                node.wordsIndexes.add(i);
                node = node.nexts.get(c);
            }
        }
        dfs(-1, words[0].length(), words, root, new ArrayList<String>(), res);
        return res;
    }
    public void dfs(int insertedCharIndex, int wordLen, String[] words, TrieNode root, List<String> square, List<List<String>> res) {
        if (insertedCharIndex == wordLen - 1) {
            res.add(new ArrayList<String>(square));
            return;
        }
        TrieNode node = root;
        for (String inserted : square) {
            if (!node.nexts.containsKey(inserted.charAt(insertedCharIndex + 1))) {
                return;
            }
            node = node.nexts.get(inserted.charAt(insertedCharIndex + 1));
        }
        for (int wordIndex : node.wordsIndexes) {
            square.add(words[wordIndex]);
            dfs(insertedCharIndex + 1, wordLen, words, root, square, res);
            square.remove(square.size() - 1);
        }
    }
}
