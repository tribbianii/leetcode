package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
	public TreeLinkNode connect(TreeLinkNode root) {
		if (root == null) {
			return root;
		}
		TreeLinkNode curr = root;
		TreeLinkNode nextLvelLeftest = root.left;
		while (nextLvelLeftest != null) {
			while (curr != null) {
				curr.left.next = curr.right;
				curr.right.next = curr.next == null ? null : curr.next.left;
				curr = curr.next;
			}
			curr = nextLvelLeftest;
			nextLvelLeftest = nextLvelLeftest.left;
		}
		return root;
	}
}
