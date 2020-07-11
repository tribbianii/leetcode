package leetcode;

import leetcode.Tree.TreeNode;

public class TreeMaxPathSum {
    // any node to any node
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }
    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(find(root.left), 0);
        int right = Math.max(find(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}