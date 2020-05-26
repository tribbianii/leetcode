package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringGroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null || strs.length==0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sort = String.valueOf(arr);
            if (!map.containsKey(sort)) {
                map.put(sort, new ArrayList<String>());
            }
            map.get(sort).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}