package leetcode;
import leetcode.Tree.TreeNode;;

class Solution{

	public static void main(String[] args) {
		TreeNode g = new TreeNode(5);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(6);
		TreeNode d = new TreeNode(4);
		d.left = g;
		TreeNode b = new TreeNode(5);
		b.left = d;
		TreeNode c = new TreeNode(6);
		c.left = e;
		c.right = f;
		TreeNode a = new TreeNode(4);
		a.left = b;
		a.right = c;
		TreeMaxNumDistinctVal example = new TreeMaxNumDistinctVal();
		System.out.println(example.findMax(a));
	}

}
