package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.Tree.TreeLinkNode;

public class TreePopulatingNextRightPointersInEachNode {

	public void PopulatingNextRightPointersInEachNode(TreeLinkNode root) {
		if (root==null) {
			return;
		}
		Queue<TreeLinkNode> level = new LinkedList<>();
		while (!level.isEmpty()) {
			TreeLinkNode node = level.poll();
			if (level.poll()!=null) {
				TreeLinkNode nextnode = level.poll();
				node.next = nextnode;
				level.offer(nextnode);
			}
			else {
				node.next = null;
			}
			if (node.left!=null) {
				level.add(node.left);
			}
			if (node.right!=null) {
				level.add(node.right);
			}
		}
	}
}
