package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.Tree.TreeNode;

public class TreeBinaryTreeZigZagTraversal {
    // odd line from left to right
    // even line from right to left
    public static List<Integer> ZigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int sign = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (sign == 0) {
                for (int i = 0; i < size; i ++) {
                    TreeNode node = deque.pollFirst();
                    res.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }
                sign = 1;
            } else {
                for (int i = 0; i < size; i ++) {
                    TreeNode node = deque.pollLast();
                    res.add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
                sign = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(ZigZag(root));
    }
}