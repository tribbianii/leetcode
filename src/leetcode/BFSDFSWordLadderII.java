package leetcode;

import java.util.*;

public class BFSDFSWordLadderII {
    // the most time consumed when trying find the neighbors of word A
    // trying replacing chars in A with other 25 chars using much less time than
    // trying going through whole list and compare A and every other word to determine whether they're neighbors
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Set<String>> map = new HashMap<>();
        Deque<String> curr_level_deque = new ArrayDeque<>();
        Set<String> curr_level_set = new HashSet<>();
        Set<String> prev_levels_set = new HashSet<>();
        int level_num = 0;
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
        if (!endWord_found) {
            System.out.println("not found");
            return res;
        }
        dfs(map, beginWord, endWord, level_num, new ArrayList<String>(Arrays.asList(beginWord)), res);
        return res;
    }
    public void dfs(Map<String, Set<String>> map, String curr_word, String end_word, int level_left, List<String> path, List<List<String>> res) {
        if (level_left == 0 && curr_word.equals(end_word)) {
            res.add(new ArrayList<String>(path));
            return;
        }
        if (level_left > 0) {
            for (String next : map.get(curr_word)) {
                path.add(next);
                dfs(map, next, end_word, level_left - 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}