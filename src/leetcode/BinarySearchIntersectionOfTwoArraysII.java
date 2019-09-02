package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchIntersectionOfTwoArraysII{
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
        //traverse the shorter array and binary search the longer one 
        if (len1<=len2){
            for (int i=0;i<len1;i++){
                if (exist(nums2, nums1[i])){
                    inter.add(nums1[i]);
                    nums2 = remove(nums2, nums1[i]);
                }
            }
        }else {
            for (int i=0;i<len2;i++){
                if (exist(nums1, nums2[i])){
                    inter.add(nums2[i]);
                    nums1 = remove(nums1, nums2[i]);
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
    //define remove element from sorted array function
    //nums[i] = nums[i+1] and append Integer.MAX_VALUE at end
    public int[] remove(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while (start!=end){
            int mid = start+(end-start)/2;
            if (nums[mid]==target){
                for (int i=mid;i<nums.length-1;i++){
                    nums[i] = nums[i+1];
                }
                nums[nums.length-1] = Integer.MAX_VALUE;
                return nums;
            }
            if (nums[mid]>target){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return nums;
    }
    //my method. a little slow
}