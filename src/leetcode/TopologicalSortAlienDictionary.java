package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSortAlienDictionary {
    public String alienOrder(String[] words){
        Map<Character,Set<Character>> later = new HashMap<>();
        Map<Character,Integer> prev = new HashMap<>();
        String res = "";
        for (String word:words){
            for (char ch:word.toCharArray()){
                prev.put(ch,0);
            }
        }
        for (int i=0;i<words.length-1;i++){
            String first = words[i];
            String second = words[i+1];
            int len = Math.min(first.length(), second.length());
            for (int j=0;j<len;j++){
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);
                if (ch1!=ch2){
                    Set<Character> set = new HashSet<>();
                    if (later.containsKey(ch1)){
                        set = later.get(ch1);
                    }
                    if (!set.contains(ch2)){
                        set.add(ch2);
                        later.put(ch1, set);
                        prev.put(ch2,prev.get(ch2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<Character>();
        for (char ch3:prev.keySet()){
            if (prev.get(ch3)==0){
                q.offer(ch3);
            }
        }
        while (!q.isEmpty()){
            char ch4 = q.poll();
            res += ch4;
            if (later.containsKey(ch4)){
                Set<Character> set = later.get(ch4);
                for (char ch5:set){
                    prev.put(ch5,prev.get(ch5)-1);
                    if (prev.get(ch5)==0){
                        q.offer(ch5);
                    }
                }
            }
        }
        return res.length()==prev.size()?res:"";
    }
}