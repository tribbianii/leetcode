package leetcode;

import java.util.HashSet;
import java.util.Set;



class TreePathSumToTargetII {
    //path from one node to itself or to any of its descendants
    public boolean exist(TreeNode root, int target) {
        return dfs(root, new HashSet<Integer>(), 0, target);
    }
    // backtracking
    private boolean dfs (TreeNode root, Set<Integer> set, int currSum, int target) {
        if (root == null) {
            return set.contains(target);
        }
        currSum = currSum + root.val;
        if (set.contains(currSum - target)) {
            return true;
        }
        boolean existed = set.contains(currSum);
        set.add(currSum);
        boolean left = dfs(root.left, set, currSum, target);
        if (!existed) {
            set.remove(currSum);
        }
        boolean right = dfs(root.right, set, currSum, target);
        return left || right;
    }
    /*following method also works, instead of backtracking, we snapshot the set
    private boolean dfs (TreeNode root, Set<Integer> set, int currSum, int target) {
        if (root == null) {
            return set.contains(target);
        }
        currSum = currSum + root.val;
        if (set.contains(currSum - target)) {
            return true;
        }
        set.add(currSum);
        Set<Integer> copy = new HashSet<>(set);
        return dfs(root.left, set, currSum, target) || dfs(root.right, copy, currSum, target);
    }
    */
}