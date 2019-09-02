package leetcode;

public class TreeUniqueBinaryTree {

	public int UniqueBinaryTree(int n) {
		if (n<1){
            return 0;
        }
        int [] nums = new int[n+1];
        //use array to store the results of previous ones for dynamic programming
        nums[0] = 1;
        nums[1] = 1;
        for (int i=2; i<=n; i++){
		    for (int j=0; j<i; j++) {
			    nums[i]+=nums[j]*nums[i-j-1];
		    }
        }
        return nums[n];
    }
}
