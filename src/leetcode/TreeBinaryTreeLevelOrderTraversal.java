package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.Tree.TreeNode;

public class TreeBinaryTreeLevelOrderTraversal {

	public List<List<Integer>> BinaryTreeLevelOrderTraversal(TreeNode root) {
		
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Deque<TreeNode> Level = new LinkedList<>();
		//queue is first-in-first-out, can be replaced with stack with right->left traversal
		if (root==null) {
			return res;
		}
		Level.offer(root);
		while (!Level.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = Level.size();
			//in for loop Level.size() will change due to poll operation so should be stored at first
			for (int i=0;i<size;i++) {
				TreeNode node = Level.pollFirst();
				level.add(node.val);
                if (node.left!=null) {
					Level.offer(node.left);
				}
				if (node.right!=null) {
					Level.offer(node.right);
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
	public List<List<Integer>> levelOrder(TreeNode root){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root==null){return res;}
		Deque<TreeNode> level = new LinkedList<>();
		level.offer(root);
		while (!level.isEmpty()){
			ArrayList<Integer> list = new ArrayList<>();
			int size = level.size();
			for (int i=0;i<size;i++){
				//Note: Deque.poll() to poll the FIRST element
				TreeNode node = level.poll();
				list.add(node.val);
				if (node.left!=null){
					level.offer(node.left);
				}
				if (node.right!=null){
					level.offer(node.right);
				}
			}
			res.add(new ArrayList<Integer>(list));
		}
		return res;
	}
}















