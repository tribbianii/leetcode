package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Tree.TreeNode;

class DesignBSTIterator {
    /*    
              ___   end
             /   |   \
            /    a    \
           /   / | \   \
          /   b  |  c   \
         /  /    |    \  \
        /  d     |     e  \ 
    start        |_________\   
    
    */
    Deque<TreeNode> deque;
    
    public DesignBSTIterator(TreeNode root) {
        this.deque = new ArrayDeque<TreeNode>();
        pushLeftMost(root);
    }
    
    public void pushLeftMost(TreeNode root) {
        while (root != null) {
            deque.offerLast(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = deque.pollLast();
        if (node.right != null) {
           pushLeftMost(node.right); 
        }
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}