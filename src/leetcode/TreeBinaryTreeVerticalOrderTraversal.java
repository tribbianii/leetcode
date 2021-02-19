package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



class TreeBinaryTreeVerticalOrderTraversal {
    /*
                  3
                /   \
              9       8
            /   \   /   \
          4      0 1      7
        [
        [4],
        [9],
        [3,0,1],
        [8],
        [7]
        ]
    */
    class Node {
        int col;
        TreeNode treenode;
        Node (int i,TreeNode k) {
            this.col = i;
            this.treenode = k;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        int minCol = 0;
        int maxCol = 0;
        queue.offer(new Node(0, root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            minCol = node.col < minCol ? node.col : minCol;
            maxCol = node.col > maxCol ? node.col : maxCol;
            map.putIfAbsent(node.col, new ArrayList<Integer>());
            map.get(node.col).add(node.treenode.val);
            if (node.treenode.left != null) {
                queue.offer(new Node(node.col - 1, node.treenode.left));
            }
            if (node.treenode.right != null) {
                queue.offer(new Node(node.col + 1, node.treenode.right));
            }
        }
        while (minCol <= maxCol) {
            res.add(map.get(minCol));
            minCol ++;
        }
        return res;
    }
}