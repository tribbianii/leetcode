package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public String replace(String input, String source, String target) {
        List<Integer> indices = findSub(input, source);
        if (indices.size() == 0){
            return input;
        }
        int len1 = input.length();
        int len2 = source.length();
        int len3 = target.length();
        int diff = len3 - len2;
        int len = len1 + indices.size() * diff;
        char[] res = new char[len];
        int times = 0;
        for (int i = 0;i < len;i ++){
            if (times < indices.size()){
                if (i != indices.get(times) + times * diff){
                    res[i] = input.charAt(i - times * diff);
                }
                else {
                    for (int j = 0;j < len3;j ++){
                        res[i+j] = target.charAt(j);
                    }
                    times ++;
                    i += (len3 -1);
                }
            }
            else {
                res[i] = input.charAt(i - times*diff);
            }
        }
        return new String(res);
    }
    private List<Integer> findSub(String input, String sub) {
        List<Integer> indices = new ArrayList<>();
        int len1 = input.length();
        int len2 = sub.length();
        for (int i = 0; i <= len1 - len2; i++){
            if (input.charAt(i) == sub.charAt(0)){
                int j = 0;
                while (j < len2 && input.charAt(i+j) == sub.charAt(j)){
                    j ++;
                }
                if (j == len2){
                    indices.add(i);
                    i += (len2-1);
                }
            }
        }
        return indices;
    }
}