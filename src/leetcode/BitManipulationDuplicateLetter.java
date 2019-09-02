package leetcode;

public class BitManipulationDuplicateLetter{
    public boolean exist(String word) {
        if (word==null || word.length()==0) {
            return false;
        }
        int[] dict = new int[8];
        for (int i = 0;i < word.length();i++) {
            int index = (word.charAt(i)) / 32;
            int offset = (word.charAt(i)) % 32;
            if ((dict[index] >> offset & 1)==1){
                return true;
            }
            else {
                dict[index] = dict[index] | (1 << offset);
            }
        }
        return false;
    }
}