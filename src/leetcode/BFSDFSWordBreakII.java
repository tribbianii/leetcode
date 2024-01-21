package leetcode;

import java.util.*;

public class BFSDFSWordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            minLen = Math.min(minLen, str.length());
            maxLen = Math.max(maxLen, str.length());
            dict.add(str);
        }
        return dfs(dict, new HashMap<>(), s, minLen, maxLen);
    }
    public List<String> dfs(Set<String> dict, Map<String, List<String>> map, String str, int minLen, int maxLen) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        List<String> list = new ArrayList<>();
        if (dict.contains(str)) {
            list.add(str);
        }
        for (int mid = minLen; mid <= Math.min(maxLen, str.length() - 1); mid ++) {
            String prefix = str.substring(0, mid);
            if (dict.contains(prefix)) {
                for (String suffix : dfs(dict, map, str.substring(mid), minLen, maxLen)) {
                    list.add(prefix + " " + suffix);
                }
            }
        }
        map.put(str, list);
        return list;
    }
}
