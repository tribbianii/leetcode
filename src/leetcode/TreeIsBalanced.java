package leetcode;

import leetcode.Tree.TreeNode;

public class TreeIsBalanced {
    // O(n * log(n)) solution
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        else if (Math.abs(getheight(root.left) - getheight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getheight(TreeNode root){
        if (root == null){
            return 0;
        }
        else {
            return Math.max(getheight(root.left), getheight(root.right)) + 1;
        }
    }
    // O(n) solution
    public boolean IsBalanced(TreeNode root) {
        return GetHeight(root) != -1;
    }
    private int GetHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = GetHeight(root.left);
        int right = GetHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}