package leetcode;

public class ArrayMergeSortedArray{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0){
            for (int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m+n;j++){
                if (nums2[i]<=nums1[j]){
                    insert(nums1,n,m,j,nums2[i]);
                    break;
                }
                else if(j>=m+i){
                    nums1[j]=nums2[i];
                }
                else {
                    continue;
                }
            }
        }
    }
    public void insert(int[]nums,int n,int m, int index, int num){
        for (int i=n+m-1;i>index;i--){
            nums[i]=nums[i-1];
        }
        nums[index]=num;
    }
}