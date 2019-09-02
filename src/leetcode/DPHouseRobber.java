package leetcode;

public class DPHouseRobber{
    public int rob(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        for (int i=0;i<len;i++){
            nums[i] = nums[i] + Math.max(i<2?0:nums[i-2],i<3?0:nums[i-3]);
        }
        return Math.max(len<1?0:nums[len-1],len<2?0:nums[len-2]);
    }
}