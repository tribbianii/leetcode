package leetcode;

import java.util.*;

public class BFSDFSWordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
    }
    public List<String> dfs(String suffix, Set<String> dict, Map<String,List<String>> map) {
        if (map.containsKey(suffix)) {
            return map.get(suffix);
        }
        List<String> suffixSentenceList = new ArrayList<>();
        if (suffix.isEmpty()) {
            suffixSentenceList.add("");
            return suffixSentenceList;
        } else {
            for (int i = 1; i <= suffix.length(); i ++) {
                String newPrefix = suffix.substring(0, i);
                if (dict.contains(newPrefix)) {
                    String newSuffix = suffix.substring(i);
                    for (String newSuffixSetence : dfs(newSuffix, dict, map)) {
                        suffixSentenceList.add(newPrefix + (newSuffixSetence.isEmpty() ? "" : " ") + newSuffixSetence);
                    }
                }
            }
            map.put(suffix, suffixSentenceList);
            return suffixSentenceList;
        }
    }
}
