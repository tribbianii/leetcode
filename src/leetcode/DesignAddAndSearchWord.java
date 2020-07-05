package leetcode;

public class DesignAddAndSearchWord {

    class Chara {
        Chara[] nexts;
        boolean isWord;
        Chara() {
            this.nexts = new Chara[26];
            this.isWord = false;
        }
    }
    
    Chara root;
    
    /** Initialize your data structure here. */
    public DesignAddAndSearchWord() {
        this.root = new Chara();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Chara node = root;
        for (char c : word.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new Chara();
            }
            node = node.nexts[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
        /* bfs slower
        int index = 0;
        Queue<Chara> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            char c = word.charAt(index);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Chara node = q.poll();
                if (c == '.') {
                    for (Chara next : node.nexts) {
                        if (index == word.length() - 1) {
                            if (next != null && next.isWord) {
                                return true;
                            }
                        }
                        else {
                            if (next != null) {
                                q.offer(next);
                            }
                        }
                    }
                }
                else {
                    Chara next = node.nexts[c - 'a'];
                    if (index == word.length() - 1) {
                        if (next != null && next.isWord) {
                            return true;
                        }
                    }
                    else {
                        if (next != null) {
                            q.offer(next);
                        }
                    }
                }
            }
            index ++;
        }
        return false;
        */
    }
    public boolean dfs(char[] word, int index, Chara node) {
        if (index == word.length) {
            return node.isWord;
        }
        if (word[index] != '.') {
            return node.nexts[word[index] - 'a'] != null && dfs(word, index + 1, node.nexts[word[index] - 'a']);
        }
        else {
            for (Chara next : node.nexts) {
                if (next != null && dfs(word, index + 1, next)) {
                    return true;
                }
            }
        }
        return false;
    }
}