package leetcode;

import leetcode.Tree.TreeNode;

class TreeInsertNode {
    public TreeNode insert (TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        return locate(root, null, target);
    }
    public TreeNode locate (TreeNode curr, TreeNode parent, int target) {
        if (curr == null) {
            curr = new TreeNode(target);
            if (parent.val < target) {
                parent.right = curr;
            }
            else {
                parent.left = curr;
            }
            return curr;
        }
        if (curr.val < target) {
            curr.right = locate(curr.right, curr, target);
        }
        else {
            curr.left = locate(curr.left, curr, target);
        }
        return curr;
    }

    //concise version
    public TreeNode Insert (TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target); 
        }
        if (root.val < target) {
            root.right = Insert(root.right, target);
        }
        else {
            root.left = Insert(root.left, target);
        }
        return root;
    }
}