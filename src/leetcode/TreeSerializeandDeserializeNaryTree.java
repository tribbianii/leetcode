package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeSerializeandDeserializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNaryNode root) {
        return new String(dfsS(root, new StringBuilder()));
    }

    public StringBuilder dfsS(TreeNaryNode root, StringBuilder res) {
        if (root == null) {
            res.append("null,");
            return res;
        }
        List<TreeNaryNode> children = root.children;
        res.append(root.val).append(",").append(children == null ? 0 : children.size()).append(",");
        for (TreeNaryNode child : children) {
            dfsS(child, res);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNaryNode deserialize(String data) {
        Deque<String> strDeque = new LinkedList<>();
        for (String str : data.split(",")) {
            strDeque.offerLast(str);
        }
        return dfsD(strDeque);
    }

    public TreeNaryNode dfsD(Deque<String> strDeque) {
        String val = strDeque.pollFirst();
        if (val.equals("null")) {
            return null;
        }
        TreeNaryNode node = new TreeNaryNode(Integer.parseInt(val), new ArrayList<TreeNaryNode>());
        int childrenNum = Integer.parseInt(strDeque.pollFirst());
        while (childrenNum > 0) {
            node.children.add(dfsD(strDeque));
            childrenNum --;
        }
        return node;
    }
}
