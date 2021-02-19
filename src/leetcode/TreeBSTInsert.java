package leetcode;

public class TreeBSTInsert {
    //iterative solution
    public TreeNode insertIntoBST(TreeNode root, int target){
        if (root == null) {
            return  new TreeNode(target);
        }
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == target) {
                return root;
            }
            prev = curr;
            curr = curr.val < target ? curr.right : curr.left;
        }
        if (prev.val > target) {
            prev.left = new TreeNode(target);
        } else {
            prev.right = new TreeNode(target);
        }
        return root;
    }
    //recusive solution 1
    public TreeNode INsert(TreeNode root, int target){
        if (root == null){
            return new TreeNode(target);
        }
        else if (root.val < target){
            root.right = INsert(root.right, target);
        }
        else if (root.val > target){
            root.left = INsert(root.left, target);
        }
        //contains root.val == target case
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
    //following is FALSE
    //cannot insert TreeNode in middle of BST like LinkedList
    //ALL values of leftSubTree < root.val, ALL values of rightSubTree > root.val
    public TreeNode insertNode(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        TreeNode node = new TreeNode(target);
        if (root.val < target) {
            if (root.right != null && root.right.val < target) {
                node.right = root.right;
                root.right = node;
            } else {
                root.right = insertNode(root.right, target);
            }
        } else if (root.left != null && root.left.val > target) {
            node.left = root.left;
            root.left = node;
        } else {
            root.left = insertNode(root.left, target);
        }
        return root;
    }
}