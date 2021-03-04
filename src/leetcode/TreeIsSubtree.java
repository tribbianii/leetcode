package leetcode;



public class TreeIsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return equal(s, t) || (s != null  && (isSubtree(s.left, t) || isSubtree(s.right, t)));
    }
    public boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
        }
    }
}
