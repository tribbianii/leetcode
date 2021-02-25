package leetcode;

public class TreeBSTInOrderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode nearestGreater = p.right;
        if (nearestGreater != null) {
            while (nearestGreater != null) {
                p = nearestGreater;
                nearestGreater = nearestGreater.left;
            }
            return p;
        } else {
            while (root != p) {
                if (root.val > p.val) {
                    nearestGreater = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return nearestGreater;
        }
    }
}
