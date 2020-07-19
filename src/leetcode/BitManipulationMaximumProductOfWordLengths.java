package leetcode;

import java.util.*;

public class BitManipulationMaximumProductOfWordLengths{
    public int maxProduct(String[] words) {
        int max = 0;
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        int[] masks = new int[words.length];
        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }
        for(int i = 0; i < masks.length; i++){
            if(words[i].length() * words[i].length() <= max){
                break;
            }
            for(int j = i + 1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return max;
    }
    // following BFS2 solution exceeded time limit on leetcode corner case
    public int MaxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int[] masks = new int[words.length];
        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (words[b[0]].length() * words[b[1]].length()) - (words[a[0]].length() * words[a[1]].length())
        );
        pq.offer(new int[]{0, 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if ((masks[curr[0]] & masks[curr[1]]) == 0) {
                return words[curr[0]].length() * words[curr[1]].length();
            }
            if (curr[1] < words.length - 1 && curr[0] != curr[1] + 1) {
                pq.offer(new int[]{curr[0], curr[1] + 1});
            }
            if (curr[0] < words.length - 1 && curr[0] + 1 != curr[1]) {
                pq.offer(new int[]{curr[0] + 1, curr[1]});
            }
        }
        return 0;
    }
}