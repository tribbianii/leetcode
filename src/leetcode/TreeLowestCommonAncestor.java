package leetcode;



// find the lowest level common ancestor of two given nodes
// if either of these two nodes doesn't exist, return null
public class TreeLowestCommonAncestor{
    public TreeNode LowestCommon(TreeNode root, TreeNode a, TreeNode b) {
        if (findEither(root, a, b) != a && findEither(root, a, b) != b) {
            return findEither(root, a, b);
        }
        else {
            if (findEither(root, a, b) == a) {
                return findEither(a, b, b) == null ? null : a;
            }
            else {
                return findEither(b, a, a) == null ? null : b;
            }
        }
    }
    private TreeNode findEither(TreeNode root, TreeNode a, TreeNode b) {
        if (root==null || root==a || root==b) {
            return root;
        }
        TreeNode left = findEither(root.left, a, b);
        TreeNode right = findEither(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        else {
            return left == null ? right : left;
        }
    }
}