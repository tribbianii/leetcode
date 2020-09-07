package leetcode;

import leetcode.Tree.TreeNode;

public class TreeBSTPrintInRange {
    public void inRange(TreeNode root, int low, int high){
        if (root==null){
            return;
        }
        if (root.val > low){
            inRange(root.left,low,high);
        }
        if (root.val >= low && root.val <= high){
            System.out.println(root.val);
        }
        if (root.val < high){
            inRange(root.right,low,high);
        }
    }
}