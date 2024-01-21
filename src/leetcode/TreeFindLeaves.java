package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFindLeaves {
    // my genius solution
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        while (collect(res, root) != null) {
            res.add(new ArrayList<Integer>());
        }
        return res;
    }
    public TreeNode collect(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            res.get(res.size() - 1).add(root.val);
            return null;
        }
        root.left = collect(res, root.left);
        root.right = collect(res, root.right);
        return root;
    }

    //according to bottom-up level
    //not modifying input
    public List<List<Integer>> FindLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> leaves = new HashMap<>();
        dfs(root, leaves);
        int level = 0;
        while (leaves.containsKey(level)) {
            res.add(leaves.get(level));
            level ++;
        }
        return res;
    }

    public int dfs(TreeNode root, Map<Integer, List<Integer>> leaves) {
        if (root == null) {
            return -1;
        }
        int leftLevel = dfs(root.left, leaves);
        int rightLevel = dfs(root.right, leaves);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (!leaves.containsKey(level)) {
            leaves.put(level, new ArrayList<Integer>());
        }
        leaves.get(level).add(root.val);
        return level;
    }
}
