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
}