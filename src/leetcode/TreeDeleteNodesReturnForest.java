package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeDeleteNodesReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : to_delete) {
            set.add(num);
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(root, set, res, true);
        return res;
    }
    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean parent_deleted) {
        if (root != null) {
            if (set.contains(root.val)) {
                dfs(root.left, set, res, true);
                dfs(root.right, set, res, true);
                return null;
            }
            root.left = dfs(root.left, set, res, false);
            root.right = dfs(root.right, set, res, false);
            if (parent_deleted) {
                res.add(root);
            }
        }
        return root;
    }
}
