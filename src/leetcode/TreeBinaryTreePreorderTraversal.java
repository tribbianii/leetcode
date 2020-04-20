package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.Tree.TreeNode;

public class TreeBinaryTreePreorderTraversal {
	public List<Integer> BinaryTreePreorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		helper(res,root);
		return res;
	}
	public void helper(List<Integer> res,TreeNode root) {
		if (root==null) {
			return;
		}
		res.add(root.val);
		helper(res,root.left);
		helper(res,root.right);
	}
	//method1 only use list, fastest
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(!stack.isEmpty() || root!= null) {
			if(root!= null) {
				stack.offer(root);
				result.add(root.val);
				root= root.left;
			} else {
				TreeNode node = stack.pollLast();
				root= node.right;   
			}
		}
		return result;
	}
	//iteration method
}
