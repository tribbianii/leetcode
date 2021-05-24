package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreePopulatingNextRightPointersInEachNode {

	public TreeLinkNode connect(TreeLinkNode root) {
		if (root == null) {
			return null;
		}
		TreeLinkNode curr = root;
		TreeLinkNode nextLevelLeftest = root.left;
		while (nextLevelLeftest != null) {
			while (curr != null) {
				curr.left.next = curr.right;
				curr.right.next = curr.next == null ? null : curr.next.left;
				curr = curr.next;
			}
			curr = nextLevelLeftest;
			nextLevelLeftest = nextLevelLeftest.left;
		}
		return root;
	}
}
