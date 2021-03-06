package leetcode;

import java.util.*;

public class DesignSerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        return new String(dfsS(root, new StringBuilder()));
    }

    public StringBuilder dfsS(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null,");
            return res;
        }
        res.append(root.val).append(",");
        dfsS(root.left, res);
        dfsS(root.right, res);
        return res;
    }

    public TreeNode deserialize(String str) {
        Deque<String> strDeque = new LinkedList<>();
        for (String val : str.split(",")) {
            strDeque.offerLast(val);
        }
        return dfsD(strDeque);
    }

    public TreeNode dfsD(Deque<String> strDeque) {
        String val = strDeque.pollFirst();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsD(strDeque);
        node.right = dfsD(strDeque);
        return node;
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
    //my solution
    //no "null" in serialized string, only real tree node value with level and index
    public String mySerialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        Deque<Integer> indexDeque = new ArrayDeque<>();
        nodeDeque.offerLast(root);
        indexDeque.add(0);
        int level = 0;
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = nodeDeque.pollFirst();
                int index = indexDeque.pollFirst();
                res.append(level).append(".").append(index).append(".").append(node.val).append(",");
                if (node.left != null) {
                    nodeDeque.offerLast(node.left);
                    indexDeque.offerLast(index * 2);
                }
                if (node.right != null) {
                    nodeDeque.offerLast(node.right);
                    indexDeque.offerLast(index * 2 + 1);
                }
            }
            level ++;
        }
        return new String(res);
    }

    public TreeNode myDeserialize(String str) {
        if (str.length() < 1) {
            return null;
        }
        String[] infoArr = str.split(",");
        Deque<String> infoDeque = new ArrayDeque<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        infoDeque.offerLast(infoArr[0]);
        TreeNode root = new TreeNode(Integer.parseInt(infoArr[0].split("\\.")[2]));
        nodeDeque.offerLast(root);
        int arrIndex = 1;
        while (arrIndex < infoArr.length) {
            TreeNode node = nodeDeque.pollFirst();
            String[] nodeInfo = infoDeque.pollFirst().split("\\.");
            int currLevel = Integer.parseInt(nodeInfo[0]);
            int currIndex = Integer.parseInt(nodeInfo[1]);
            String[] childInfo = infoArr[arrIndex].split("\\.");
            if (Integer.parseInt(childInfo[0]) == currLevel + 1 &&
                    Integer.parseInt(childInfo[1]) == currIndex * 2) {
                node.left = new TreeNode(Integer.parseInt(childInfo[2]));
                infoDeque.offerLast(infoArr[arrIndex]);
                nodeDeque.offerLast(node.left);
                arrIndex ++;
            }
            if (arrIndex == infoArr.length) {
                break;
            }
            childInfo = infoArr[arrIndex].split("\\.");
            if (Integer.parseInt(childInfo[0]) == currLevel + 1 &&
                    Integer.parseInt(childInfo[1]) == currIndex * 2 + 1) {
                node.right = new TreeNode(Integer.parseInt(childInfo[2]));
                infoDeque.offerLast(infoArr[arrIndex]);
                nodeDeque.offerLast(node.right);
                arrIndex ++;
            }
        }
        return root;
    }
}