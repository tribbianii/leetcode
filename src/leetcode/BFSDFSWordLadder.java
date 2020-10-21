package leetcode;

import java.util.*;

public class BFSDFSWordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Map<String, Set<String>> map = new HashMap<>();
        Deque<String> curr_level_deque = new ArrayDeque<>();
        Set<String> curr_level_set = new HashSet<>();
        Set<String> prev_levels_set = new HashSet<>();
        int level_num = 1;
        boolean endWord_found = false;
        curr_level_deque.offerLast(beginWord);
        prev_levels_set.add(beginWord);
        map.put(beginWord, new HashSet<String>());
        while (!curr_level_deque.isEmpty()) {
            int size = curr_level_deque.size();
            for (int i = 0; i < size; i ++) {
                String curr = curr_level_deque.pollFirst();
                char[] arr = curr.toCharArray();
                Set<String> neighbors = new HashSet<>();
                for (int j = 0; j < arr.length; j ++) {
                    char old = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (old != ch) {
                            arr[j] = ch;
                            String next = String.valueOf(arr);
                            if (next.equals(endWord)) {
                                endWord_found = true;
                            }
                            if (dict.contains(next) && !prev_levels_set.contains(next)){
                                curr_level_deque.offerLast(next);
                                neighbors.add(next);
                            }
                        }
                    }
                    arr[j] = old;
                }
                map.put(curr, neighbors);
                curr_level_set.addAll(neighbors);
            }
            level_num ++;
            if (endWord_found) {
                break;
            }
            prev_levels_set.addAll(curr_level_set);
            curr_level_set.clear();
        }
        return endWord_found ? level_num : 0;
    }
}