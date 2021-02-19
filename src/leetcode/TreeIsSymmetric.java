package leetcode;



public class TreeIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return  root == null || compare(root.left, root.right);
    }
    public boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left);
        }
        return left == null && right == null;
    }
}