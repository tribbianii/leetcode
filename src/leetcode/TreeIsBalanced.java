package leetcode;

import leetcode.Tree.TreeNode;

public class TreeIsBalanced {
    public boolean isBalanced(TreeNode root){
        if (root==null){
            return true;
        }
        else if (Math.abs(getheight(root.left) - getheight(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getheight(TreeNode root){
        if (root==null){
            return 0;
        }
        else {
            return Math.max(getheight(root.left),getheight(root.right))+1;
        }
    }
}