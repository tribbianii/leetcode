package leetcode;

public class ArrayRotateArray { 
	public static void RotateArray(int[] nums, int k) {
		int len = nums.length;
        int[] temp = new int[len];
        for (int m=0;m<len;m++){
            temp[m]=nums[m];
        }
		for (int i=len-(k%len),j=0;j<len;j++) {
			if (i>=len){
                i=i-len;
            }
            nums[j]=temp[i];
			i++;
		}
		System.out.println(nums.toString());
	}
	//above is method1
	//replicate a new array for traversal
	
	public void rotate(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	//above is method2
	//reverse whole array-->reverse part before Kth element-->reverse part after Kth element

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		RotateArray(arr,2);
	}
}