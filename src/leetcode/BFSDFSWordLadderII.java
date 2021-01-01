package leetcode;

import java.util.*;

public class BFSDFSWordLadderII {
    // the most time consumed when trying find the neighbors of word A
    // trying replacing chars in A with other 25 chars using much less time than
    // trying going through whole list and compare A and every other word to determine whether they're neighbors
    static class Path {
        public String tail;
        public List<String> path;
        public Path(String endWord) {
            this.tail = endWord;
            this.path = new ArrayList<String>();
            this.path.add(endWord);
        }
        public Path(String endWord, Path prev) {
            this.tail = endWord;
            this.path = new ArrayList<>(prev.path);
            this.path.add(endWord);
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Deque<Path> deque = new ArrayDeque<Path>();
        Set<String> prev_levels_set = new HashSet<>();
        Set<String> curr_level_set = new HashSet<>();
        deque.offerLast(new Path(beginWord));
        prev_levels_set.add(beginWord);
        boolean found = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                Path from = deque.pollFirst();
                char[] arr = from.tail.toCharArray();
                List<String> prev = from.path;
                boolean foundFromThisWord = false;
                for (int j = 0; j < arr.length; j ++) {
                    char old = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (old != ch) {
                            arr[j] = ch;
                            String next = String.valueOf(arr);
                            if (dict.contains(next) && !prev_levels_set.contains(next)){
                                if (next.equals(endWord)) {
                                    List<String> list = new ArrayList<>(prev);
                                    list.add(endWord);
                                    res.add(list);
                                    foundFromThisWord = true;
                                    found = true;
                                } else {
                                    deque.offerLast(new Path(next, from));
                                    curr_level_set.add(next);
                                }
                            }
                        }
                        if (foundFromThisWord) {
                            break;
                        }
                    }
                    if (foundFromThisWord) {
                        break;
                    }
                    arr[j] = old;
                }
            }
            if (found) {
                break;
            }
            prev_levels_set.addAll(curr_level_set);
            curr_level_set.clear();
        }
        return res;
    }
}