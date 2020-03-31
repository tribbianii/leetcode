package leetcode;

import java.util.Stack;

import leetcode.Tree.TreeNode;

class DesignBSTIterator {
    Stack<TreeNode> stack;
    
    public DesignBSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        pushLeftMost(root);
    }
    
    public void pushLeftMost(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
           pushLeftMost(node.right); 
        }
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}