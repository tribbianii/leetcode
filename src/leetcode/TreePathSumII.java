package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                res.add(path);
                return res;
            }
            return res;
        }
        List<List<Integer>> pathsLeft = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> pathsRight = pathSum(root.right, targetSum - root.val);
        for (List<Integer> path : pathsLeft) {
            path.add(0, root.val);
            res.add(path);
        }
        for (List<Integer> path : pathsRight) {
            path.add(0, root.val);
            res.add(path);
        }
        return res;
    }
}
