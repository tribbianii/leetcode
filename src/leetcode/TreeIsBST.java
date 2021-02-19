package leetcode;



public class TreeIsBST {
    //Note: here the the min and max limiattion shoud be Integer.min and Integer.max
    //set to long only for werid test case on leetcode smh
    public boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, long min, long max) {
        return root == null ||
                ((long) root.val < max
                    && (long) root.val > min
                    && dfs(root.left, min, (long) root.val)
                    && dfs(root.right, (long) root.val, max));
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