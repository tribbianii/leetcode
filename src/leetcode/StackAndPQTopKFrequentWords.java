package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class StackAndPQTopKFrequentWords {
    public class Word {
        String content;
        int nums;
        Word(String content, int nums) {
            this.content = content;
            this.nums = nums;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Word> pq = new PriorityQueue<Word>(new Comparator<Word>(){
            @Override
            public int compare(Word a, Word b) {
                if (a.nums != b.nums) {
                    return b.nums - a.nums;
                } else {
                    int index = 0;
                    int limit = Math.min(a.content.length(), b.content.length());
                    while (index < limit && a.content.charAt(index) == b.content.charAt(index)) {
                        index ++;
                    }
                    if (index >= a.content.length()) {
                        return -1;
                    }
                    if (index >= b.content.length()) {
                        return 1;
                    }
                    return a.content.charAt(index) - b.content.charAt(index);
                }
            }
        });
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String key : map.keySet()) {
            pq.add(new Word(key, map.get(key)));
        }
        while (k > 0) {
            res.add(new String(pq.poll().content));
            k --;
        }
        return res;
    }
}