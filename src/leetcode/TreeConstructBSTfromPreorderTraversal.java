package leetcode;

import leetcode.Tree.TreeNode;

public class TreeConstructBSTfromPreorderTraversal {
    int index = 0;
    int[] preorder;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode construct(int lower, int upper) {
        if (index == preorder.length || preorder[index] < lower || preorder[index] > upper) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index ++;
        root.left = construct(lower, root.val);
        root.right = construct(root.val, upper);
        return root;
    }
}