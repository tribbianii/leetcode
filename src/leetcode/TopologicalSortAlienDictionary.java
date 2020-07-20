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
    public String alienDictOrder(String[] words){
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
    // outgoing + incoming solution
    Map<Character, Set<Character>> outgoing = new HashMap<>();
    Map<Character, Integer> incoming = new HashMap<>();
    StringBuilder res = new StringBuilder();
    public String alienOrder(String[] words){
        if (buildGraph(words) && bfsCheckCircle()) {
            return res.toString();
        }
        return "";
    }
    // return true if no sequence like ["ab", "a"] exists
    public boolean buildGraph(String[] words) {
        for (String word : words) {
            for (char c: word.toCharArray()) {
                outgoing.put(c, new HashSet<Character>());
                incoming.put(c, 0);
            }
        }
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
                    if (!outgoing.get(a).contains(b)) {
                        outgoing.get(a).add(b);
                        incoming.put(b, incoming.get(b) + 1);
                    }
                    break;
                }
            }
        }
        return true;
    }
    // return true if no circle exists
    public boolean bfsCheckCircle() {
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : incoming.keySet()) {
            if (incoming.get(c) == 0) {
                queue.offerLast(c);
            }
        }
        while (!queue.isEmpty()) {
            char a = queue.poll();
            for (char b : outgoing.get(a)) {
                incoming.put(b, incoming.get(b) - 1);
                if (incoming.get(b) == 0) {
                    queue.offer(b);
                }
            }
            res.append(a);
        }
        return res.length() == outgoing.size();
    }
    // dfs solution
    // faster and consume less space
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();
    
    public String AlienOrder(String[] words) {
        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }
        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i ++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j ++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            if (!dfs(c)) {
                return "";
            }
        }
        if (output.length() < reverseAdjList.size()) {
            return "";
        }
        return output.toString();
    }
    // Return true if no cycles detected.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            // If this node was grey (false), a cycle was detected.
            return seen.get(c); 
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) {
                return false;
            }
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }    
}