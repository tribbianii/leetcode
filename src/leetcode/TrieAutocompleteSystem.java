package leetcode;

import java.util.*;

public class TrieAutocompleteSystem {
    static class Record implements Comparable<Record>{
        int time;
        String content;
        Record(String c, int t) {
            this.content = c;
            this.time = t;
        }
        @Override
        public int compareTo(Record that) {
            if (this.time == that.time) {
                return this.content.compareTo(that.content);
            } else if (this.time >= that.time) {
                return -1;
            }
            return 1;
        }
    }
    static class TrieNode {
        boolean isEnd;
        TrieNode prev;
        Map<Character, TrieNode> nexts;
        List<Record> hottest;
        TrieNode() {
            this.prev = null;
            this.nexts = new HashMap<Character, TrieNode>();
            this.hottest = new ArrayList<>();
        }
    }

    TrieNode root;
    TrieNode curr;
    StringBuilder search;

    public TrieAutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.curr = root;
        this.search = new StringBuilder();
        for (int i = 0; i < sentences.length; i ++) {
            int time = times[i];
            String sentence = sentences[i];
            for (char c : sentence.toCharArray()) {
                if (!curr.nexts.containsKey(c)) {
                    curr.nexts.put(c, new TrieNode());
                    curr.nexts.get(c).prev = curr;
                }
                curr = curr.nexts.get(c);
                curr.hottest.add(new Record(sentence, time));
                Collections.sort(curr.hottest);
            }
            curr.isEnd = true;
            curr = root;
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            if (curr == root) {
                return res;
            }
            String newContent = new String(search);
            boolean searched = curr.isEnd;
            curr.isEnd = true;
            while (curr != root) {
                if (searched) {
                    for (Record record : curr.hottest) {
                        if (record.content.equals(newContent)) {
                            record.time ++;
                            break;
                        }
                    }
                } else {
                    curr.hottest.add(new Record(newContent, 1));
                }
                Collections.sort(curr.hottest);
                curr = curr.prev;
            }
            curr = root;
            search = new StringBuilder();
        } else {
            if (!curr.nexts.containsKey(c)) {
                curr.nexts.put(c, new TrieNode());
                curr.nexts.get(c).prev = curr;
            }
            curr = curr.nexts.get(c);
            search.append(c);
            for (int i = 0; i < Math.min(3, curr.hottest.size()); i ++) {
                res.add(curr.hottest.get(i).content);
            }
        }
        return res;
    }
}
