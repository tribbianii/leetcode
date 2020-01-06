package leetcode;

import leetcode.Tree.TreeNode;

public class TreeConvertTreeToDoublyLinkedList {
    //not converted to circle ring
    TreeNode head = null;
    TreeNode prev = null;
    public TreeNode treeToDoublyLinked (TreeNode root) {
        if (root == null) {
            return root;
        }
        convert(root);
        //if converted to circle ring
        /*
        prev.right = head;
        head.left = prev;
        */
        return head;
    }
    public void convert (TreeNode node) {
        if (node != null) {
            if (prev == null) {
                head = node;
            }
            else {
                node.left = prev;
                prev.right = node;
            }
            prev = node;
        }
    }
}