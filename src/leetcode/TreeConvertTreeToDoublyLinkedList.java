package leetcode;



public class TreeConvertTreeToDoublyLinkedList {
    //not converted to circle ring
    static TreeNode head = null;
    static TreeNode prev = null;
    public static TreeNode treeToDoublyLinked (TreeNode root) {
        if (root == null) {
            return root;
        }
        convert(root);
        //if converted to circle ring
        /*
        prev.right = head;
        head.left = prev;
        */
        return head;
    }
    public static void convert (TreeNode node) {
        if (node != null) {
            convert(node.left);
            if (prev == null) {
                head = node;
            }
            else {
                node.left = prev;
                prev.right = node;
            }
            prev = node;
            convert(node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        TreeNode head = treeToDoublyLinked(root);
        while (head != null) {
            System.out.println((head.left == null ? "null" : head.left.val) + " <==> " + head.val + " <==> " + (head.right == null ? "null" : head.right.val));
            head = head.right;
        }
    }
}