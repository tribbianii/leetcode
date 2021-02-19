package leetcode;



class TreeMaxSumRootToLeaf {
    public int maxSumPath (TreeNode root) {
        return root == null ? 0 : root.val + Math.max(maxSumPath(root.left), maxSumPath(root.right));
    }
}