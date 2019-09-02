package leetcode;

public class BitManipulationMaximumProductOfWordLengths{
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        for (int i=0;i<len;i++){
            String word = words[i];
            for (int j=0;j<word.length();j++){
                value[i] |= 1<<(word.charAt(j)-'a');
            }
        }
        int res = 0;
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                if ((value[i]&value[j])==0 && words[i].length()*words[j].length()>res){
                    res = words[i].length()*words[j].length();
                }
            }
        }
        return res;
    }
}