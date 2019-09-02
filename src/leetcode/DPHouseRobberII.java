package leetcode;

import java.util.Arrays;

//you can only rob one of the first and the last house or neither 
public class DPHouseRobberII{
    public int rob(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        if (len<=2){
            return Math.max(nums[0],len<2?0:nums[1]);
        }
        int[] head = Arrays.copyOfRange(nums, 0, len-1);
        int[] tail = Arrays.copyOfRange(nums, 1, len);
        //Arrays.copy(int[] array, from_index, to_index)
        //from_index inclusive
        //to_index exclusive
        return Math.max(Math.max(head[len-1],head[len-2]),Math.max(tail[len-1],tail[len-2]));
    }
    public static void helper(int[] nums){
        int len = nums.length;
        for (int i=0;i<len;i++){
            nums[i] = nums[i] + Math.max(i<2?0:nums[i-2],i<3?0:nums[i-3]);
        }
    }
    public int Rob(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        if (len<=2){
            return Math.max(nums[0],len<2?0:nums[1]);
        }
        int[] pos = nums.clone();
        int[] rev = new int[len];
        for(int i=0;i<len;i++){
            rev[i] = nums[len-1-i];
        }
        helper(pos);
        helper(rev);
        if (pos[len-1]==pos[len-2]||rev[len-1]==rev[len-2]){
            return Math.max(pos[len-1],rev[len-1]);
        }
        else if(pos[len-1]==rev[len-1]){
            return Math.max(Math.max(pos[len-1]-nums[0],pos[len-1]-nums[len-1]),Math.max(pos[len-2],rev[len-2]));
        }
        return pos[len-1];
    }
}