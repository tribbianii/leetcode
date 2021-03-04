package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeEncodeNaryTreetoBinaryTree {
    /*

    The left child of each node in the binary tree is the next sibling of the node in the N-ary tree.
    The right child of each node in the binary tree is the first child of the node in the N-ary tree.

     */
    public TreeNode encode(TreeNaryNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        if (root.children == null || root.children.size() == 0) {
            return node;
        }
        List<TreeNaryNode> children = root.children;
        node.left = encode(children.get(0));
        TreeNode curr = node.left;
        int index = 1;
        while (index < children.size()) {
            curr.right = encode(children.get(index ++));
            curr = curr.right;
        }
        return node;
    }

    // Decodes your binary tree to an n-ary tree.
    public TreeNaryNode decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNaryNode node = new TreeNaryNode(root.val, new ArrayList<TreeNaryNode>());
        List<TreeNaryNode> children = node.children;
        TreeNaryNode firstChild = decode(root.left);
        if (firstChild != null) {
            children.add(firstChild);
        }
        TreeNode curr = root.left;
        while (curr != null) {
            TreeNaryNode nextChild = decode(curr.right);
            if (nextChild != null) {
                children.add(nextChild);
            }
            curr = curr.right;
        }
        return node;
    }
}
