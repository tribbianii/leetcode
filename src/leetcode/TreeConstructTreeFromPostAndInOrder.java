package leetcode;

import java.util.HashMap;
import java.util.Map;



public class TreeConstructTreeFromPostAndInOrder {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i ++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, postOrder, map, postOrder.length - 1, 0, inOrder.length - 1);
    }
    public TreeNode construct(int[] inOrder, int[] postOrder, Map<Integer, Integer> map, int postIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) {
            return null;
        }
        int rootVal = postOrder[postIndex];
        int rootIndex = map.get(rootVal);
        int rightChildrenNum = inRightIndex - rootIndex;
        TreeNode root = new TreeNode(rootVal);
        root.right = construct(inOrder, postOrder, map, postIndex - 1, rootIndex + 1, inRightIndex);
        root.left = construct(inOrder, postOrder, map, postIndex - rightChildrenNum - 1, inLeftIndex, rootIndex - 1);
        return root;
    }
}