package leetcode;

import java.util.ArrayList;
import java.util.List;



class TreeBSTPrintPaths {
/*    Input:

          1
        /   \
       2     3
        \
          5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        build(root, res, "");
        return res;
    }
    private void build(TreeNode root, List<String> res, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                res.add(path);
                return;
            }
            path += "->";
            build(root.left, res, path);
            build(root.right, res, path);
        }
    }
}