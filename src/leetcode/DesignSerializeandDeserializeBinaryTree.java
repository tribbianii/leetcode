package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
}