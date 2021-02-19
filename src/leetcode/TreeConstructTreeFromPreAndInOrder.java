package leetcode;

import java.util.HashMap;
import java.util.Map;



public class TreeConstructTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i ++) {
            map.put(inOrder[i], i);
        }
        return construct(preOrder, inOrder, map, 0, 0, inOrder.length - 1);
    }
    public TreeNode construct(int[] preOrder, int[] inOrder, Map<Integer, Integer> map, int preIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }
        int rootVal = preOrder[preIndex];
        int rootIndex = map.get(rootVal);
        int leftChildrenNum = rootIndex - inLeftIndex;
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preOrder, inOrder, map, preIndex + 1, inLeftIndex, rootIndex - 1);
        root.right = construct(preOrder, inOrder, map, preIndex + leftChildrenNum + 1, rootIndex + 1, inRightIndex);
        return root;
    }
}