package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeNaryPreOrder {
    public List<Integer> preorder(TreeNaryNode root) {
        Deque<TreeNaryNode> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNaryNode node = deque.pollLast();
            res.add(node.val);
            if (node.children != null) {
                int index = node.children.size() - 1;
                while (index >= 0) {
                    deque.offerLast(node.children.get(index --));
                }
            }
        }
        return res;
    }
}
