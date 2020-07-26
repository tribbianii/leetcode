package leetcode;

import java.util.Arrays;

import leetcode.Tree.TreeNode;;

class Solution{

	public static void main(String[] args) {
		TreeNode g = new TreeNode(5);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(6);
		TreeNode d = new TreeNode(4);
		d.left = g;
		TreeNode b = new TreeNode(5);
		b.left = d;
		TreeNode c = new TreeNode(6);
		c.left = e;
		c.right = f;
		TreeNode a = new TreeNode(4);
		a.left = b;
		a.right = c;
		TreeMaxNumDistinctVal example = new TreeMaxNumDistinctVal();

		int[] arr1 = new int[]{100,200,300};
		int[] arr2 = new int[]{200,400};
		BFSDFSNearestSumCombin test = new BFSDFSNearestSumCombin();

		ArraySubArraySumEqualsK wetry = new ArraySubArraySumEqualsK();
		int[] arr = new int[]{1,2,3,4,-4,-3,-2,1};
		wetry.subArrSum(arr, 0).forEach(array -> System.out.println(Arrays.toString(array)));

		
        TreeNode root = new TreeNode(-15); 
        root.left = new TreeNode(5); 
        root.right = new TreeNode(6); 
        root.left.left = new TreeNode(-8); 
        root.left.right = new TreeNode(1); 
        root.left.left.left = new TreeNode(2); 
        root.left.left.right = new TreeNode(6); 
        root.right.left = new TreeNode(3); 
        root.right.right = new TreeNode(9); 
        root.right.right.right = new TreeNode(0); 
        root.right.right.right.left = new TreeNode(4); 
        root.right.right.right.right = new TreeNode(-1); 
		root.right.right.right.right.left = new TreeNode(10); 
		TreeMaxSumLeafToLeaf exa = new TreeMaxSumLeafToLeaf();
		//System.out.println(exa.go(root));

		int[] level = new int[]{1,6,5,7,4,10,9};
		int[] inorder = new int[]{4,1,10,5,9,6,7};
		int[] data = new int[]{1,2,3,1,2,3,1,2,3,1,6,5,7,4,10,9};
		DesignStreamFirstNonRepeating fnr = new DesignStreamFirstNonRepeating(data);
		System.out.println(Arrays.toString(fnr.generateFNR()));
		TreeConstructTreeFromLevelAndInOrder exam = new TreeConstructTreeFromLevelAndInOrder();
		System.out.println(exam.reconstruct(inorder, level).val);
	}

}
