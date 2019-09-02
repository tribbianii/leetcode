package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchRussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null||envelopes.length==0){
            return 0;
        }
        int len = envelopes.length;
        int[] dp_h = new int[len];
        Arrays.fill(dp_h,1);
        int max_h = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] env1,int[] env2){
                if (env1[0]==env2[0]) {
                    return 0;
                }
                else {
                    return env1[0] > env2[0] ? 1 : -1;
                }
            }
        });
        //equals to following sort method
        //Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=1;i<len;i++){
            for (int j=i-1;j>=0;j--){
                if (envelopes[j][1]<envelopes[i][1]&&envelopes[j][0]<envelopes[i][0]){
                    dp_h[i] = Math.max(dp_h[i], dp_h[j]+1);
                }
            }
            max_h = Math.max(max_h, dp_h[i]);
        }
        return max_h;
    }
    //my method
    public int MaxEnvelopes(int[][] envelopes) {
        if (envelopes==null||envelopes.length==0){
            return 0;
        }
        int len = envelopes.length;
        int[] dp_h = new int[len];
        Arrays.fill(dp_h,1);
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] env1,int[] env2){
                if (env1[0]==env2[0]){
                    if (env2[1]==env1[1]) {
                        return 0;
                    }
                    return env2[1] > env2[1] ? 1 : -1;
                    //ensure sort env with same width in descending order by height
                    //avoid counting env with same width/longer height contain short height
                }
                else {
                    if (env1[0]==env2[0]) {
                        return 0;
                    }
                    return env1[0] > env2[0] ? 1 : -1;
                }
            }
        });
        //following comes same algorithm with longest increasing sequence adapts
        int max = 0;
        for (int[] env : envelopes) {
            int left = 0;
            int right = max;
            while (left != right) {
                int mid = (left + right) / 2;
                if (dp_h[mid] < env[1]){
                    left= mid + 1;
                }
                else{
                    right = mid;
                }
            }
            dp_h[left] = env[1];
            if (left==max) {
                ++max;
            }
        }
        return max;
    }
}