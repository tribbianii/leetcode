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