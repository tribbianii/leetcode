package leetcode;



public class TreeIsBalanced {
    // O(n * log(n)) solution
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        else if (Math.abs(getTheheight(root.left) - getTheheight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getTheheight(TreeNode root){
        if (root == null){
            return 0;
        }
        else {
            return Math.max(getTheheight(root.left), getTheheight(root.right)) + 1;
        }
    }
    // O(n) solution
    public boolean IsBalanced(TreeNode root){
        return getHeight(root) >= 0;
    }
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}