package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraySubArraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int counts = nums[0] == k ? 1 : 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        
        for (int n = 1;n < nums.length;n ++){
            nums[n] = nums[n - 1] + nums[n];
            if (map.containsKey(nums[n] - k)){
                counts += map.get(nums[n] - k);
            }
            map.put(nums[n], map.getOrDefault(nums[n], 0) + 1);
        }
        
        return counts;
    }

    public ArrayList<int[]> subArrSum (int[] arr, int target) {
        /*
        create a map to store <key, value>
            key: the sum calculated from index 0 to current 
            value: list of indexes that have the sum equals to corresponding key
        at beginning, we insert (0, {-1}) into map
        */
        Map<Integer, ArrayList<Integer>> sumTillNow = new HashMap<>();
        ArrayList<int[]> res = new ArrayList<int[]>();
        int sum = 0;
        for (int i = 0; i < arr.length; i ++) {
            //update sum
            sum = sum + arr[i];
            //if sum equals to target, then cut array from 0 to current
            if (sum == target) {
                res.add(Arrays.copyOfRange(arr, 0, i + 1));
            }
            //if the sum equals to (newSum - target) already existed
            if (sumTillNow.containsKey(sum - target)) {
                //cut every valid subArray
                for (int index : sumTillNow.get(sum - target)) {
                    res.add(Arrays.copyOfRange(arr, index + 1, i + 1));
                }
            }
            //if the sum equals to (newSum - target) doesn't exist
            //see if the newsum existed or not, if not, we creat a pair
            if (!sumTillNow.containsKey(sum)) {
                sumTillNow.put(sum, new ArrayList<Integer>());
            }
            //add this index
            sumTillNow.get(sum).add(i);
        }
        return res;
    }
}