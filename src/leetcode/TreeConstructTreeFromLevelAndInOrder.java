package leetcode;

import java.util.HashMap;
import java.util.Map;



public class TreeConstructTreeFromLevelAndInOrder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, levelOrder, map, 0, levelOrder.length - 1);
    }

    public TreeNode construct(int[] inOrder, int[] levelOrder, Map<Integer, Integer> map, int level_l, int level_r) {
        if (level_l > level_r) {
            return null;
        }
        int val = levelOrder[0];
        int mid = map.get(val);
        int[] l_level = new int[mid - level_l];
        int[] r_level = new int[level_r - mid];
        int l_index = 0;
        int r_index = 0;
        TreeNode node = new TreeNode(val);
        for (int element : levelOrder) {
            if (element != val) {
                if (map.get(element) < mid) {
                    l_level[l_index++] = element;
                } else {
                    r_level[r_index++] = element;
                }
            }
        }
        node.left = construct(inOrder, l_level, map, level_l, mid - 1);
        node.right = construct(inOrder, r_level, map, mid + 1, level_r);
        return node;
    }
}