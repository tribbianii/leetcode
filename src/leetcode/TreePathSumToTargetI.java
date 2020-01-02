package leetcode;

import leetcode.Tree.TreeNode;

class TreePathSumToTargetI {
    //path from root to leaf
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
          return false;
        }
        if (root.left == null && root.right == null) {
          return root.val == target;
        }
        if (root.left != null && root.right != null) {
          return exist(root.left, target - root.val) || exist(root.right, target - root.val);
        }
        return root.left == null ? exist(root.right, target - root.val) : exist(root.left, target - root.val);
      }
}