package leetcode;

import leetcode.Tree.TreeNode;

public class TreeIsBST {
    //Note: here the the min and max limiattion shoud be Integer.min and Integer.max
    //set to long only for werid test case on leetcode smh
    public boolean isValidBST(TreeNode root){
        return  isbst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isbst(TreeNode root, long low, long high){
        if (root==null){
            return true;
        }
        if (root.val <= low || root.val >= high){
            return false;
        }
        return isbst(root.left,low,root.val) && isbst(root.right,root.val,high);
    }
    //here comes the dumber solution
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return go(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean go (TreeNode root, int min, int max) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return root.right.val > root.val && root.right.val < max && go(root.right, root.val, max);
        }
        if (root.right == null) {
            return root.left.val < root.val && root.left.val > min && go(root.left, min, root.val);
        }
        return root.right.val > root.val && root.right.val < max && go(root.right, root.val, max) && root.left.val < root.val && root.left.val > min && go(root.left, min, root.val);
    }
}