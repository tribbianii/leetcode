package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchIntersectionOfTwoArrays{
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> inter = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1*len2==0){
            return new int[]{};
        }
        if (nums1[0]>nums2[len2-1]||nums1[len1-1]<nums2[0]){
            return new int[]{};
        }
        if (len1<=len2){
            for (int i=0;i<len1;i++){
                if (i>0&&nums1[i]==nums1[i-1]){
                    continue;
                }
                else {
                    if (exist(nums2, nums1[i])){
                        inter.add(nums1[i]);
                    }
                }
            }
        }else {
            for (int i=0;i<len2;i++){
                if (i>0&&nums2[i]==nums2[i-1]){
                    continue;
                }
                else {
                    if (exist(nums1, nums2[i])){
                        inter.add(nums2[i]);
                    }
                }
            }
        }
        if (inter.size()==0){
            return new int[]{};
        }
        else {
            int[] res = new int[inter.size()];
            for (int i=0;i<res.length;i++){
                res[i] = inter.get(i);
            }
            return res;
        }
    }
    public boolean exist(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while (start!=end){
            int mid = start+(end-start)/2;
            if (nums[mid]==target){
                return true;
            }
            if (nums[mid]>target){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return nums[start]==target;
    }
    //my method beats 98% solutions
    //can also use Set or HashMap
}