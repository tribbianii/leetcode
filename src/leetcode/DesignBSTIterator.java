package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Tree.TreeNode;

class DesignBSTIterator {
    Deque<TreeNode> stack;
    
    public DesignBSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<TreeNode>();
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