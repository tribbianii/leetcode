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
            int newRoot = findSmallest (root.right);
            root.val = newRoot;
            root.right = delete (root.right, newRoot);
            return root;
        }
    }
    public int findSmallest (TreeNode root) {
        int min = 0;
        while (root != null) {
            min = root.val;
            root = root.left;
        }
        return min;
    }
}