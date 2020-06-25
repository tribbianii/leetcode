package leetcode;

import leetcode.Tree.TreeNode;

class TreeMaxSumLeafToLeaf { 
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null || (root.left == null || root.right == null)) {
          return max;
        }
        find(root);
        return max;
    }
    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = find(root.left);
        int right = find(root.right);
        if (root.left != null && root.right != null) {
            max = Math.max(max, root.val + left + right);
            return root.val + Math.max(left, right);
        }
        return root.left == null ? root.val + right : root.val + left;
    }
}