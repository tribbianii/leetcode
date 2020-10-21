package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSDFSWordSearchII {
    static class TrieNode {
        Map<Character, TrieNode> map;
        String wordEndsHere;
        TrieNode() {
            this.map = new HashMap<>();
            this.wordEndsHere = null;
        }
    }
    public int[] dirs = new int[]{1, 0, -1, 0, 1};
    public List<String> findWords(char[][] board, String[] words){
        List<String> res = new ArrayList<>();
        // construct the trie
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for (String word : words) {
            node = root;
            for (char c : word.toCharArray()) {
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new TrieNode());
                }
                node = node.map.get(c);
            }
            node.wordEndsHere = word;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                dfs(res, board, root, i, j, visited);
            }
        }
        return res;
    }
    public void dfs(List<String> res, char[][] board, TrieNode node, int x, int y, boolean[][] visited) {
        if (x < board.length && x >= 0 && y < board[0].length && y >= 0 && !visited[x][y] && node.map.containsKey(board[x][y])) {
            node = node.map.get(board[x][y]);
            if (node.wordEndsHere != null) {
                res.add(node.wordEndsHere);
                // remove words after being added into res to avoid duplicate
                node.wordEndsHere = null;
            }
            visited[x][y] = true;
            for (int i = 0; i < dirs.length - 1; i ++) {
                int newX = x + dirs[i];
                int newY = y + dirs[i + 1];
                dfs(res, board, node, newX, newY, visited);
            }
            visited[x][y] = false;
        }
    }
}
