package leetcode;

public class ArrayMedianOfTwoSortedArrays{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = (len1 + len2) / 2 + 1;
        int index1 = 0;
        int index2 = 0;
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < len3; i ++) {
            prev = curr;
            int a = index1 < len1 ? nums1[index1] : Integer.MAX_VALUE;
            int b = index2 < len2 ? nums2[index2] : Integer.MAX_VALUE;
            if (a <= b){
                curr = a;
                index1 ++;
            }
            else {
                curr = b;
                index2 ++;
            }
        }
        if ((len1 + len2) % 2 == 0){
            return (float)(prev + curr) / 2;
        }
        else {
            return (float)curr;
        }
    }
}