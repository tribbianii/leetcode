package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSortAlienDictionary {
    //topological sort step: Delete the vertexof in-degree 0(with no incoimng arrows) and all its outgoing(all outgoing arrows) edgesfrom the graph, then place it in the output
    //https://courses.cs.washington.edu/courses/cse326/03wi/lectures/RaoLect20.pdf
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> outgoing = new HashMap<>();
        int[] indegree = new int[26];
        buildGraph(outgoing, indegree, words);
        return bfs(outgoing, indegree);
    }
    public void buildGraph(Map<Character, Set<Character>> outgoing, int[] indegree, String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                outgoing.putIfAbsent(c, new HashSet<>());
            }
        }      
        for (int i = 0;i < words.length - 1;i ++) {
            String first = words[i];
            String second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0;j < len;j ++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    if (!outgoing.get(c1).contains(c2)) {
                        indegree[c2 - 'a'] ++;
                    }
                    outgoing.get(c1).add(c2);
                    break;
                }
            }
        }
    }
    public String bfs(Map<Character, Set<Character>> outgoing, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<Character>();
        for (char c : outgoing.keySet()) {
            if (indegree[c - 'a'] == 0) {
                q.offer(c);
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            if (outgoing.containsKey(c)) {
                Set<Character> set = outgoing.get(c);
                for (char next : set) {
                    indegree[next - 'a'] --;
                    if (indegree[next - 'a'] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return sb.length() == outgoing.size() ? sb.toString() : "";
    }
}