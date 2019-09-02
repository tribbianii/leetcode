package leetcode;

import java.util.HashSet;

//Determine whether the  given word can be composed by contenating words in dictionary
//time complexity is O(n^3) 'cause we have two for loop and substring operation takes O(n)
public class DPWordsConcatenating {
    public boolean wordSolver(String word, HashSet<String> dict) {
        boolean[] contain = new boolean[word.length() + 1];
        for (int i = 1;i <= word.length();i++) {
            if (dict.contains(word.substring(0, i))) {
                contain[i] = true;
                continue;
            }
            else {
                for (int j = 1;j < i;j++) {
                    if (contain[j] && dict.contains(word.substring(j, i))) {
                        contain[i] = true;
                        break;
                    }
                }
            }
        }
        return contain[word.length()];
    }
}