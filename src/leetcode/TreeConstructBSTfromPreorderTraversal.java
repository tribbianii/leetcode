package leetcode;



public class TreeConstructBSTfromPreorderTraversal {
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int min, int max) {
        if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        index ++;
        node.left = build(preorder, min, node.val);
        node.right = build(preorder, node.val, max);
        return node;
    }
}