package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



public class TreeBinaryTreeInOrderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(!stack.isEmpty() ||root!= null) {
			if(root!= null) {
				stack.offer(root);
				root= root.left;
			} else {
				TreeNode node = stack.pollLast();
				result.add(node.val);
				root= node.right;   
			}
		}
		return result;
	}
	//iteration method
	
	public List<Integer> binaryTreeInOrderTraversal(TreeNode root){
		List<Integer> res = new LinkedList<Integer>();
		helper(root,res);
		return res;
	}
	public static void helper(TreeNode root, List<Integer> res) {
		if (root==null) {
			return;
		}
		helper(root.left,res);
		res.add(root.val);
		helper(root.right,res);	
	}
	//method2 use recursion to track down to most left node and return back upward
	//faster
}
