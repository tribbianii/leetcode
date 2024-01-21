package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopologicalSortAlienDictionary {
    // dfs solution
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String str : words) {
            for (char c : str.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i ++) {
            String str_1 = words[i];
            String str_2 = words[i + 1];
            int index = 0;
            while (index < Math.min(str_1.length(), str_2.length())) {
                char a = str_1.charAt(index);
                char b = str_2.charAt(index);
                if (a != b) {
                    map.get(b).add(a);
                    break;
                }
                index ++;
            }
            if (index < str_1.length() && index == str_2.length()) {
                return "";
            }
        }
        int[] status = new int[26];
        StringBuilder order = new StringBuilder();
        for (Character c : map.keySet()) {
            if (!dfs(map, status, c, order)) {
                return "";
            }
        }
        return new String(order);
    }

    public boolean dfs(Map<Character, Set<Character>> map, int[] status, char c, StringBuilder order) {
        if (status[c - 'a'] == 2) {
            return true;
        }
        if (status[c - 'a'] == 1) {
            return false;
        }
        status[c - 'a'] = 1;
        for (char prev : map.get(c)) {
            if (!dfs(map, status, prev, order)) {
                return false;
            }
        }
        status[c - 'a'] = 2;
        order.append(c);
        return true;
    }
    //my solution, super fast
    class Node{
        char letter;
        int index;
        Set<Node> prevs;
        Set<Node> nexts;
        Node(char c) {
            this.letter = c;
            this.index = 0;
            this.prevs = new HashSet<>();
            this.nexts = new HashSet<>();
        }
    }
    Map<Character, Node> map = new HashMap<>();
    public String AlienDictOrder(String[] words){
        // build mapping between char and node
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, new Node(c));
                }
            }
        }
        // return "" if circle found
        if (!BuildGraph(words)) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Deque<Node> queue = new ArrayDeque<>();
        for (char c : map.keySet()) {
            // start with root nodes having index = 0
            if (map.get(c).index == 0) {
                queue.offer(map.get(c));
            }
        }
        while (!queue.isEmpty()) {
            Node a = queue.poll();
            for (Node b : a.nexts) {
                // one of b's precedents polled, b's index --
                b.index --;
                if (b.index == 0) {
                    queue.offer(b);
                }
            }
            res.append(a.letter);
        }
        return res.toString();
    }
    public boolean BuildGraph(String[] words) {
        for (int i = 0; i < words.length - 1; i ++) {
            String curr = words[i];
            String next = words[i + 1];
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return false;
            }
            for (int j = 0; j < Math.min(curr.length(), next.length()); j ++) {
                char a = curr.charAt(j);
                char b = next.charAt(j);
                if (a != b) {
                    Node first = map.get(a);
                    Node second = map.get(b);
                    // if a circle found, return false
                    if (first.prevs.contains(second) || second.nexts.contains(first)) {
                        return false;
                    }
                    // if a new precedent found, index ++
                    second.index = second.prevs.contains(first) ? second.index : second.index + 1;
                    // add second into first's descendants
                    first.nexts.add(second);
                    // add first and first's precedents into second's precedents
                    second.prevs.add(first);
                    second.prevs.addAll(first.prevs);
                    break;
                }
            }
        }
        return true;
    }

}