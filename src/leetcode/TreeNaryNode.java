package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNaryNode implements Tree{
    int val;
    List<TreeNaryNode> children;
    TreeNaryNode(int value, List<TreeNaryNode> children) {
        this.val = value;
        this.children = children;
    }
}
