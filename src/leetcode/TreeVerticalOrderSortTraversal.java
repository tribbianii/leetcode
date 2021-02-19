package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class TreeVerticalOrderSortTraversal {
    class Node {
        int col;
        int row;
        TreeNode treenode;
        Node (int i,int j, TreeNode k) {
            this.col = i;
            this.row = j;
            this.treenode = k;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        int minCol = 0;
        int maxCol = 0;
        queue.offer(new Node(0, 0, root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            minCol = node.col < minCol ? node.col : minCol;
            maxCol = node.col > maxCol ? node.col : maxCol;
            map.putIfAbsent(node.col, new ArrayList<Node>());
            map.get(node.col).add(node);
            if (node.treenode.left != null) {
                queue.offer(new Node(node.col - 1, node.row + 1, node.treenode.left));
            }
            if (node.treenode.right != null) {
                queue.offer(new Node(node.col + 1, node.row + 1, node.treenode.right));
            }
        }
        while (minCol <= maxCol) {
            map.get(minCol).sort(new Comparator<Node>(){
                @Override
                public int compare(Node a, Node b) {
                    if (a.row < b.row) {
                        return -1;
                    } else if (a.row > b.row) {
                        return 1;
                    } else {
                        return a.treenode.val - b.treenode.val;
                    }
                }
            });
            List<Integer> col = new ArrayList<>();
            for (Node node : map.get(minCol)) {
                col.add(node.treenode.val);
            } 
            res.add(col);
            minCol ++;
        }
        return res;
    }
}