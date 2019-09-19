package leetcode;

import leetcode.Tree.TreeNode;

class TreeMaxSumLeafToLeaf { 
    class Max {
        int val;
    }
    public int go (TreeNode root) {
        Max max = new Max();
        max.val = Integer.MIN_VALUE;
        maxSumPath(root, max);
        return max.val;
    }
    public int maxSumPath (TreeNode root, Max max) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int fromLeft = maxSumPath(root.left, max);
        int fromRight = maxSumPath(root.right, max);
        if (root.left != null && root.right != null) {
            max.val = fromLeft + fromRight + root.val > max.val ? fromLeft + fromRight + root.val : max.val;
            return Math.max(fromLeft, fromRight) + root.val;
        }
        return root.left == null ? fromRight + root.val : fromLeft + root.val;
    }
}