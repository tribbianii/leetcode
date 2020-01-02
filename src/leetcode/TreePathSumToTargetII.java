package leetcode;

import java.util.HashSet;
import java.util.Set;

import leetcode.Tree.TreeNode;

class TreePathSumToTargetII {
    //path from one node to itself or to any of its descendants
    public boolean exist(TreeNode root, int target) {
        return find(root, new HashSet<Integer>(), 0, target);
    }
    private boolean find (TreeNode root, Set<Integer> set, int currSum, int target) {
        if (root == null) {
            return set.contains(target);
        }
        currSum = currSum + root.val;
        if (set.contains(currSum - target)) {
            return true;
        }
        boolean existed = set.contains(currSum);
        set.add(currSum);
        boolean left = find(root.left, set, currSum, target);
        if (!existed) {
            set.remove(currSum);
        }
        boolean right = find(root.right, set, currSum, target);
        return left || right;
    }
    /*following method also works, instead of backtracking, we snapshot the set
    private boolean find (TreeNode root, Set<Integer> set, int currSum, int target) {
        if (root == null) {
            return set.contains(target);
        }
        currSum = currSum + root.val;
        if (set.contains(currSum - target)) {
            return true;
        }
        set.add(currSum);
        Set<Integer> copy = new HashSet<>(set);
        return find(root.left, set, currSum, target) || find(root.right, copy, currSum, target);
    }
    */
}