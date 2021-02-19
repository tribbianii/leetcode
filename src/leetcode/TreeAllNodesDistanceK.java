package leetcode;

import java.util.*;

public class TreeAllNodesDistanceK {
    static Map<Integer, DoublyTreeNode> map = new HashMap<Integer, DoublyTreeNode>();
    static class DoublyTreeNode {
        int val;
        DoublyTreeNode left;
        DoublyTreeNode right;
        DoublyTreeNode parent;
        static DoublyTreeNode constructDT(TreeNode node) {
            if (node == null) {
                return null;
            }
            DoublyTreeNode DTnode = new DoublyTreeNode();
            DTnode.val = node.val;
            DTnode.left = constructDT(node.left);
            DTnode.right = constructDT(node.right);
            if (DTnode.left != null) {
                DTnode.left.parent = DTnode;
            }
            if (DTnode.right != null) {
                DTnode.right.parent = DTnode;
            }
            map.put(node.val, DTnode);
            return DTnode;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        DoublyTreeNode newRoot = DoublyTreeNode.constructDT(root);
        DoublyTreeNode newTarget = map.get(target.val);
        List<Integer> res = new ArrayList<>();
        dfs(newTarget, new HashSet<Integer>(), K, res);
        return res;
    }
    public void dfs(DoublyTreeNode node, Set<Integer> set, int dist, List<Integer> res) {
        if (node == null || set.contains(node.val)) {
            return;
        }
        if (dist == 0) {
            res.add(node.val);
            return;
        }
        set.add(node.val);
        dfs(node.parent, set, dist - 1, res);
        dfs(node.left, set, dist - 1, res);
        dfs(node.right, set, dist - 1, res);
        set.remove(node.val);
    }
}
