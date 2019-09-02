package leetcode;

import leetcode.Tree.TreeNode;

public class TreeAreIdentical {
    public boolean areIdentical(TreeNode one, TreeNode two){
        if (one==null && two==null){
            return true;
        }
        else if (one==null || two==null){
            return false;
        }
        else if (one.val != two.val){
            return false;
        }
        return areIdentical(one.left, two.left)&&areIdentical(one.right, two.right) || areIdentical(one.left, two.right)&&areIdentical(one.right, two.left);
    }
}