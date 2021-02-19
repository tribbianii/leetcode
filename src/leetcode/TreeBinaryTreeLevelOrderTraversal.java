package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



public class TreeBinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerLast(root);
		while (!deque.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = deque.size();
			for (int i = 0; i < size; i ++) {
				TreeNode node = deque.pollFirst();
				level.add(node.val);
				if (node.left != null) {
					deque.offerLast(node.left);
				}
				if (node.right != null) {
					deque.offerLast(node.right);
				}
			}
			res.add(level);
		}
		return res;
	}
//use queue to store nodes on the same level and poll them out
//use ArrayList with variable length to store nodes' value on the same level
	
	public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		dfs(0,root,res);
		return res;
	}
	
	public static void dfs(int index, TreeNode root, List<List<Integer>> res) {
		if (root==null) {
			return;
		}
		if (res.size()<=index) {
			res.add(new ArrayList<Integer>());
		}
		res.get(index).add(root.val);
		dfs(index+1, root.left, res);
		dfs(index+1, root.right, res);
	}
//recursion to store the depth of level and put the value into list
//if the index deeper than current level, than add a new list and continue inserting
}















