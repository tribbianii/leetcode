package leetcode;

import java.util.ArrayList;
import java.util.List;

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
}
