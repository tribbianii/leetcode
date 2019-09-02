package leetcode;

import leetcode.Tree.TreeNode;

public class TreeInvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null || root.left==null&&root.right==null){
            return root;
        }
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        return root;
    }
}