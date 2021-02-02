package leetcode;

public class TreeBSTClosetValue {
    double minDiff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if ((double)(root.val) == target) {
            return root.val;
        }
        double diff = (double)(root.val) - target;
        if (Math.abs(minDiff) > Math.abs(diff)) {
            minDiff = diff;
        }
        if (diff > 0 && root.left != null) {
            return closestValue(root.left, target);
        } else if (diff < 0 && root.right != null) {
            return closestValue(root.right, target);
        }
        return (int)(target + minDiff);
    }
}
