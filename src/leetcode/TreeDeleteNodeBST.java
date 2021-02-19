package leetcode;



//there can be two valid status with deleted node replaced by
//either the smallest node among all nodes in deleted.right
//or the greatest node among all nodes in deleted.left
//here we adopt the first one
public class TreeDeleteNodeBST{
    public TreeNode deleteNode(TreeNode root, int target){
        if (root==null){
            return null;
        }
        else if (root.val < target){
            root.right = deleteNode(root.right, target);
            return root;
        }
        else if (root.val > target){
            root.left = deleteNode(root.left, target);
            return root;
        }
        else if (root.left == null || root.right == null){
            return root.left == null ? root.right : root.left;
        }
        else if (root.right.left == null){
            root.right.left = root.left;
            return root.right;
        }
        else {
            TreeNode replace = extractSmallest(root.right);
            replace.left = root.left;
            replace.right = root.right;
            return replace;
        }
    }
    private TreeNode extractSmallest(TreeNode root) {
        TreeNode prev = root;
        TreeNode curr = root.left;
        while (curr.left != null){
            prev = curr;
            curr = curr.left;
        }
        prev.left = curr.right;
        return curr;
    }
}