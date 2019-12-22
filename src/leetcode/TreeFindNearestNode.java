package leetcode;

import leetcode.Tree.TreeNode;

class TreeFindNearestNode {
    public TreeNode findNearest (TreeNode root, int target) {
        TreeNode ans = root;
        while (root != null) {
            if (root.val == target) {
                return root;
            }
            root = root.val > target ? root.left : root.right;
            ans = Math.abs(root.val - target) > Math.abs(ans.val - target) ? ans : root;
        }
        return ans;
    }

    //recursion solution
    public TreeNode ans;
    public TreeNode FindNearest (TreeNode root, int target) {
        if (root == null) {
            return ans;
        }
        if (root.val == target) {
            return root;
        }
        ans = Math.abs(root.val - target) > Math.abs(ans.val - target) ? ans : root;
        return root.val > target ? FindNearest (root.left, target) : FindNearest (root.right, target);
    }

    //follow-up: find the largest node in all nodes smaller than target
    public TreeNode find (TreeNode root, int target) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val >= target) {
                root = root.left;
                continue;
            }
            ans = root;
            root = root.right;
        }
        return ans;
    } 
}