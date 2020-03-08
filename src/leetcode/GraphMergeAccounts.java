package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

class GraphMergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }
        Map<String, String> relation = new HashMap<>();
        Map<String, Set<String>> neighbors = new HashMap<>();
        buildGraph(accounts, relation, neighbors);
        Set<String> visited = new HashSet<>();
        for (String email : relation.keySet()) {
            if (!visited.contains(email)) {
                List<String> profile = new ArrayList<>();
                dfs(email, visited, neighbors, profile);
                Collections.sort(profile);
                profile.add(0, relation.get(email));
                res.add(profile);
            }
        }
        return res;
    }
    public void buildGraph(List<List<String>> accounts, Map<String, String> relation, Map<String, Set<String>> neighbors) {
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            relation.put(firstEmail, name);
            for (int i = 2; i < account.size(); i++) {
                relation.put(account.get(i), name);
                neighbors.putIfAbsent(account.get(i), new HashSet<>());
                neighbors.putIfAbsent(account.get(i - 1), new HashSet<>());
                neighbors.get(account.get(i)).add(account.get(i - 1));
                neighbors.get(account.get(i - 1)).add(account.get(i));
            }
        }
    }
    public void dfs(String email, Set<String> visited, Map<String, Set<String>> neighbors, List<String> profile) {
        profile.add(email);
        visited.add(email);
        if (neighbors.containsKey(email)){
            for (String neighbor : neighbors.get(email)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, visited, neighbors, profile);
                }
            }
        }
    }
}