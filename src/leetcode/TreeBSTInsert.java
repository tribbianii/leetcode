package leetcode;

import leetcode.Tree.TreeNode;

public class TreeBSTInsert {
    //iterative solution
    public TreeNode insertIntoBST(TreeNode root, int target){
        if (root==null){
            return new TreeNode(target);
        }
        TreeNode node  = root;
        while (node!=null){
            if (node.val < target){
                if (node.right==null){
                    node.right = new TreeNode(target);
                    return root;
                }
                else {
                    node = node.right;
                }
            }
            else if (node.val > target){
                if (node.left==null){
                    node.left = new TreeNode(target);
                    return root;
                }
                else {
                    node = node.left;
                }
            }
            else {
                return root;
            }
        }
        return root;
    }
    //recusive solution 1 with redundant operations
    public TreeNode INsert(TreeNode root, int target){
        if (root==null){
            return new TreeNode(target);
        }
        else if (root.val < target){
            root.right = INsert(root.right, target);
        }
        else if (root.val > target){
            root.left = INsert(root.left, target);
        }
        return root;
    }
    //recusive solution 2
    public void Insert(TreeNode root, TreeNode item){
        if (root==null || root.val==item.val){
            return;
        }
        else if (root.val < item.val){
            if (root.right==null){
                root.right = item;
                return;
            }
            else {
                Insert(root.right, item);
            }
        }
        else {
            if (root.left==null){
                root.left = item;
                return;
            }
            else {
                Insert(root.left, item);
            }
        }
    }
    //recursive solution 3
    public TreeNode insertnode(TreeNode root, int target){
        if (root==null){
            return new TreeNode(target);
        }
        else if (root.val < target){
            if (root.right==null){
                return new TreeNode(target);
            }
            else {
                root.right = insertnode(root.right, target);
            }
        }
        else if (root.val > target){
            if (root.left==null){
                return new TreeNode(target);
            }
            else {
                root.left = insertnode(root.left, target);
            }
        }
        return root;
    }
}