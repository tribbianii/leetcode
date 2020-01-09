package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.Tree.TreeNode;

public class TreeConstructTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, preOrder, map, 0, 0, inOrder.length - 1);
    }

    public TreeNode construct(int[] inOrder, int[] preOrder, Map<Integer, Integer> map, int pre_curr, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int val = preOrder[pre_curr];
        int mid = map.get(val);
        int left_size = mid - in_left;
        TreeNode node = new TreeNode(val);
        node.left = construct(inOrder, preOrder, map, pre_curr + 1, in_left, mid - 1);
        node.right = construct(inOrder, preOrder, map, pre_curr + left_size + 1, mid + 1, in_right);
        return node;
    }
}