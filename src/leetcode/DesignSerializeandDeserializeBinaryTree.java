package leetcode;

import java.util.*;

import leetcode.Tree.TreeNode;

public class DesignSerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    
    // Decodes your encoded data to tree.
    public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    // following is BFS solution using level order
    // Note: ArrayDeque doesn't allow null, LinkedList does
    public String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return new String(res);
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node == null) {
                res.append("null,");
                continue;
            }
            res.append(node.val);
            res.append(",");
            deque.offerLast(node.left);
            deque.offerLast(node.right);
        }
        return new String(res);
    }

    public TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] arr = str.split(",");
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        deque.offerLast(root);
        int index = 1;
        while (index < arr.length) {
            TreeNode node = deque.pollFirst();
            if (!arr[index].equalsIgnoreCase("null")) {
                node.left = new TreeNode(Integer.valueOf(arr[index]));
                deque.offerLast(node.left);
            }
            index ++;
            if (!arr[index].equalsIgnoreCase("null")) {
                node.right = new TreeNode(Integer.valueOf(arr[index]));
                deque.offerLast(node.right);
            }
            index ++;
        }
        return root;
    }
}