package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphDeepCopy {
    //DFS solution 1
    Map<GraphNode, GraphNode> map = new HashMap<>();
    public GraphNode deepCopy (GraphNode node) {
        if (node == null) {
            return null;
        }
        if (!map.containsKey(node)) {
            map.put(node, new GraphNode(node.val));
            GraphNode copy = map.get(node);
            for (GraphNode neighbor : node.neighbors) {
                copy.neighbors.add(deepCopy(neighbor));
            }
        }
        return map.get(node);
    }
    //DFS solution 2
    Map<GraphNode, GraphNode> mapp = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        if (mapp.containsKey(node)) {
            return mapp.get(node);
        }
        GraphNode newNode = new GraphNode(node.val);
        mapp.put(node, newNode);
        for (GraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    //BFS solution
    public GraphNode DeepCopy (GraphNode root) {
        if (root == null) {
            return root;
        }
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        GraphNode newhead = new GraphNode(root.val);
        visited.put(root, newhead);
        Queue<GraphNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            GraphNode node = nodes.poll();
            GraphNode curr = visited.get(node);
            for (GraphNode neighbor : node.neighbors) { 
                if (!visited.containsKey(neighbor)) {
                    nodes.offer(neighbor);
                    visited.put(neighbor, new GraphNode(neighbor.val));
                }
                curr.neighbors.add(visited.get(neighbor));
            }
        }
        return newhead;
    }
}