package leetcode;

public class TreeCountUnivalSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        return Math.abs(count(root));
    }
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int left = count(root.left);
        int right = count(root.right);
        if (left + right > 0) {
            boolean equalToBothChildren = root.left != null && root.right != null && root.left.val == root.right.val && root.val == root.left.val;
            boolean equalToOnlyChild = root.left == null && root.val == root.right.val || root.right == null && root.val == root.left.val;
            if (equalToBothChildren || equalToOnlyChild) {
                return left + right + 1;
            }
        }
        return  -(Math.abs(left) + Math.abs(right));
    }
}
