package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeBSTUniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        for (int val = min; val <= max; val ++) {
            List<TreeNode> lefts = dfs(min, val - 1);
            List<TreeNode> rights = dfs(val + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(val);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
