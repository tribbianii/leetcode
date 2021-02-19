package leetcode;



//also refered as DP problem
//houses are tree structured and can't rob adjacently connnected houses(nodes)
public class TreeHouseRobberIII {
    public int rob(TreeNode root) {
        return Math.max(helper(root)[0],helper(root)[1]);   
    }
    public int[] helper(TreeNode root){
        if (root==null){
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //initialize arrays space to store intermediate results
        //or it will exceed time limit
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}