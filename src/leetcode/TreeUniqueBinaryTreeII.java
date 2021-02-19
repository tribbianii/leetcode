package leetcode;

import java.util.ArrayList;
import java.util.List;



public class TreeUniqueBinaryTreeII {

	public List<TreeNode> UniqueBinaryTreeII(int n) {
		if (n<=0) {
			return new ArrayList<TreeNode>();
		}
		return helper(1,n);
	}
	
	public List<TreeNode> helper(int start, int end){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (start>end) {
			res.add(null);
			return res;
		}
		for (int i=start;i<=end;i++) {
			List<TreeNode> lefts = helper(start, i-1);
		    List<TreeNode> rights = helper(i+1, end);
            for (TreeNode left:lefts) {
				for (TreeNode right:rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				} 
			}
		}
		return res;
	}
}
