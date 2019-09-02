package leetcode;

//may be duplicates in array
public class BinarySearchSearchInRotatedSortedArrayII{
    public boolean search(int[] nums, int target){
        if (nums==null||nums.length==0){
            return false;
        }
        int start = 0;
        int len = nums.length;
        int end = len-1;
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]==target){
                return true;
            }
            if (nums[pos]>nums[start]){
                if (nums[pos]>target && nums[start]<=target){
                    end = pos;
                }
                else {
                    start = pos+1;
                }
                continue;
            }
            if (nums[pos]<nums[start]){
                if (nums[pos]<target && nums[end]>=target){
                    start = pos+1;
                }
                else {
                    end = pos;
                }
                continue;
            }
            //===========================
            if (nums[pos]==nums[start]){
                start++;
            }
            //===========================
            //edited part above
            //move pos forward to get outsides of duplicates
        }
        return nums[start]==target?true:false;
    }
    //edited from previous problem method 2
    public boolean Search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return false;
        }
        int start = 0;
        int len = nums.length;
        int end = len-1;
        while (start!=end){
            int pos = start+(end-start)/2;
            if (nums[pos]==target){
                return true;
            }
            //===========================
            if (nums[pos]==nums[start]){
                start++;
                continue;
            }
            if (nums[pos]==nums[end]){
                end--;
                continue;
            }
            //===========================
            //above added into preovious problem method 1
            if (nums[pos]>target){
                if  (nums[0]>target && nums[0]<=nums[pos]){
                    start = pos+1;
                }
                else {
                    end = pos;
                }
            }
            if (nums[pos]<target){
                if (nums[len-1]<target && nums[len-1]>nums[pos]){
                    end = pos;
                }
                else {
                    start = pos+1;
                }
            }
        }
        return nums[start]==target?true:false;
    }
    //edited from previous problem method 1
}