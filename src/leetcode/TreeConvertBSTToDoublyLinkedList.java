package leetcode;



class TreeConvertBSTToDoublyLinkedList {
    /*
            4
          /   \
        2       5
      /  \
    1      3
    
    convert to :

     ==> 1 <==> 2 <==> 3 <==> 4 <==> 5 <==
    |                                    |
    |                                    |
     =====================================
     
    */
    TreeNode head;
    TreeNode tail;
    public TreeNode treeToDoublyList (TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void helper (TreeNode node) {
        if (node != null) {
            helper(node.left);
            if (head == null) {
                head = node;
            }
            if (tail != null) {
                tail.right = node;
                node.left = tail;
            }
            tail = node;
            helper(node.right);
        }
    }
}