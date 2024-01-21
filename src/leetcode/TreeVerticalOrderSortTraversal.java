package leetcode;

import java.util.*;


public class TreeVerticalOrderSortTraversal {
    class Node {
        int col;
        int row;
        TreeNode treeNode;
        Node(int colNum, int rowNum, TreeNode tNode) {
            this.col = colNum;
            this.row = rowNum;
            this.treeNode = tNode;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                if (Integer.compare(a.row, b.row) != 0) {
                    return Integer.compare(a.row, b.row);
                } else if (Integer.compare(a.col, b.col) != 0) {
                    return Integer.compare(a.col, b.col);
                } else {
                    return Integer.compare(a.treeNode.val, b.treeNode.val);
                }
            }
        });
        int minCol = 0;
        pq.offer(new Node(0, 0, root));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!map.containsKey(node.col)) {
                map.put(node.col, new ArrayList<>());
            }
            map.get(node.col).add(node.treeNode.val);
            minCol = Math.min(minCol, node.col);
            if (node.treeNode.left != null) {
                pq.offer(new Node(node.col - 1, node.row + 1, node.treeNode.left));
            }
            if (node.treeNode.right != null) {
                pq.offer(new Node(node.col + 1, node.row + 1, node.treeNode.right));
            }
        }
        while (map.containsKey(minCol)) {
            res.add(map.get(minCol ++));
        }
        return res;
    }
}