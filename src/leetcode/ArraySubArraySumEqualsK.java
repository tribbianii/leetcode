package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArraySubArraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        int counts = 0;
        int[] sum = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int n=0;n<nums.length;n++){
            sum[n] = n==0?nums[0]:sum[n-1]+nums[n];
            if (map.containsKey(sum[n]-k)){
                counts += map.get(sum[n]-k);
            }
            map.put(sum[n], map.getOrDefault(sum[n], 0)+1);
        }
        return counts;
    }
}