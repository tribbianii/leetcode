package leetcode;

public class StringExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        if (S.length() == 0) {
            return 0;
        }
        int len_s = S.length();
        char[] arr_s = S.toCharArray();
        int[] nextDiff = new int[len_s];
        int index = 0;
        int index_str = 0;
        while (index_str < len_s) {
            char s = arr_s[index_str];
            while (index_str < len_s && arr_s[index_str] == s) {
                index_str ++;
            }
            while (index < index_str) {
                nextDiff[index ++] = index_str;
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i ++) {
            char[] arr_w = words[i].toCharArray();
            int len_w = words[i].length();
            int index_s = 0;
            int index_w = 0;
            while (index_s < len_s && index_w < len_w) {
                char s = arr_s[index_s];
                char w = arr_w[index_w];
                if (s != w) {
                    break;
                }
                int num_s = nextDiff[index_s] - index_s;
                int num_w = 0;
                while (index_w < len_w && arr_w[index_w] == w) {
                    index_w ++;
                    num_w ++;
                }
                if (num_s < num_w || (num_s < 3 && num_s > num_w)) {
                    break;
                }
                index_s = nextDiff[index_s];
            }
            if (index_s == len_s && index_w == len_w) {
                res ++;
            }
        }
        return res;
    }
}
