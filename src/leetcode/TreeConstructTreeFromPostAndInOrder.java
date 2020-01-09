package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.Tree.TreeNode;

public class TreeConstructTreeFromPostAndInOrder {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, postOrder, map, inOrder.length - 1, 0, inOrder.length - 1);
    }

    public TreeNode construct(int[] inOrder, int[] postOrder, Map<Integer, Integer> map, int post_curr, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int val = postOrder[post_curr];
        int mid = map.get(val);
        int right_size = in_right - mid;
        TreeNode node = new TreeNode(val);
        node.right = construct(inOrder, postOrder, map, post_curr - 1, mid + 1, in_right);
        node.left = construct(inOrder, postOrder, map, post_curr - right_size - 1, in_left, mid - 1);
        return node;
    }
}