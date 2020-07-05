package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int val;
    List<GraphNode> neighbors;
    GraphNode (int value) {
        this.val = value;
        this.neighbors = new ArrayList<GraphNode>();
    }
    GraphNode(int value, List<GraphNode> neighbors) {
        this.val = value;
        this.neighbors = neighbors;
    }
}