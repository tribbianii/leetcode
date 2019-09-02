package leetcode;

import leetcode.Tree.TreeNode;
//determine the longest distance from one leaf node to another
public class TreeDiameterOfBT{
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return max;
    }
    private int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        max = Math.max(max, leftDep + rightDep);
        return Math.max(leftDep,rightDep) + 1;
    }
}