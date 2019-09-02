package leetcode;

import leetcode.Tree.TreeNode;

public class TreeIsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root==null){
            return true;
        }
        else {
            return IsSymmetric(root.left, root.right);
        }
    }
    private boolean IsSymmetric(TreeNode left, TreeNode right){
        if (left==null && right==null){
            return true;
        }
        else if (left==null || right==null){
            return false;
        }
        else if (left.val!=right.val){
            return false;
        }
        return IsSymmetric(left.left,right.right) && IsSymmetric(left.right,right.left);
    }
}