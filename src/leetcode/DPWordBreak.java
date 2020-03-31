package leetcode;

import java.util.HashSet;
import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words
//determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note:
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words

public class DPWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict){
            set.add(word);
        }
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if (set.contains(sub)){
                    if (breakable[j] == true){
                        breakable[i] = true;
                        break;
                    }
                }
            }
        }
        return breakable[s.length()];
    }
}
