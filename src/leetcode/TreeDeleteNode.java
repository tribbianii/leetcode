package leetcode;

import leetcode.Tree.TreeNode;

class TreeDeleteNode {
    public TreeNode delete (TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val > target) {
            root.left = delete (root.left, target);
            return root;
        }
        else if (root.val < target) {
            root.right = delete (root.right, target);
            return root;
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            //replace the root with the smalest one in root's right child nodes
            //OR the largest one in root's left child nodes
            TreeNode smallest = findSmallest (root.right);
            root.val = smallest.val;
            root.right = delete (root.right, root.val);
            return root;
        }
    }
    public TreeNode findSmallest (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}