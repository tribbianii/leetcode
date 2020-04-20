package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.Tree.TreeNode;

public class TreeBinaryTreePostoderTraversal {

	public List<Integer> BinaryTreePostoderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		helper(root, res);
		return res;
	}
	public static void helper(TreeNode root, List<Integer> res) {
		if (root==null) {
			return;
		}
		helper(root.left,res);
		helper(root.right,res);
		res.add(root.val);
	}
	//method1 output node value after traverse children nodes
	public List<Integer> binaryTreePostorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(!stack.isEmpty()||root!=null) {
			if(root!= null) {
				stack.offer(root);
				result.addFirst(root.val);  
				root= root.right;             
			} else {
				TreeNode node = stack.pollLast();
				root= node.left;           
			}
		}
		return result;
	}
	//iteration method 
}
