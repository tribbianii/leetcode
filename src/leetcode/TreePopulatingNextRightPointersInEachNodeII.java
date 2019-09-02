package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.Tree.TreeLinkNode;

public class TreePopulatingNextRightPointersInEachNodeII {

	public static void PopulatingNextRightPointersInEachNodeII(TreeLinkNode root) {
		if (root==null) {
			return;
		}
		Queue<TreeLinkNode> level  = new LinkedList<>();
		level.offer(root);
		while (!level.isEmpty()) {
			int size= level.size();
			for (int i=0;i<size;i++) {
				TreeLinkNode node1 = level.poll();
				if (i<size-1) {
					node1.next = level.peek();
					//queue.peek show the top element without removing it
					//all nodes except the last of each level have next-right pointers not null
				}
				else {
					node1.next = null;
				}
				if (node1.left!=null) {
					level.offer(node1.left);
				}
				if (node1.right!=null) {
					level.offer(node1.right);
				}
			}
		}
	}
//method1 use the idea of level order of tree
	public static void connect(TreeLinkNode root) {
		if (root==null) {
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode child = null;
		//traverse all nodes on same level
		TreeLinkNode childlevellead = null;
		//assign first node of each level, changed when traverse another level
		
		while (parent!=null) {
		//traverse level by level
			while (parent!=null) {
			//traverse node by node on same level
				if (parent.left!=null) {
					if (childlevellead!=null) {
						child.next = parent.left;
					}
					else{
						childlevellead = parent.left;
					}
					child = parent.left;
				}
				if (parent.right!=null) {
					if (childlevellead!=null) {
						child.next = parent.right;
					}
					else{
						childlevellead = parent.right;
					}
					child = parent.right;
				}
				parent = parent.next;
				//completed one node traversal and jump to next node
			}
			parent = childlevellead;
			//completed one level traversal and restart from the first node of next level
			child = null;
			childlevellead = null;
		}
	}
//method2 use two dimension traversal. space complexity O(1)
//much faster than method1
}
