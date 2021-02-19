package leetcode;

import java.util.*;

public class TreeMaxNumDistinctVal {
    public int findMax(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Set<Integer> set = new LinkedHashSet<>();
        List<Set<Integer>> counts = new ArrayList<>();
        set.add(root.val);
        traverse (root, set, counts);
        int max = 0;
        for (Set<Integer> eachSet : counts) {
            max = max > eachSet.size() ? max : eachSet.size();
        }
        return max;     
    }
    static void traverse(TreeNode root, Set<Integer> set, List<Set<Integer>> counts) {
        //This method also works
        //note: no matter which method, counts.add(new LinkedHashSet<Integer>(set)) cannot be counts.add(set);
        //doesn't have to be LinkedHashSet, HashSet is okay
        /*
        set.add(root.val);
        if (root.left==null && root.right==null) {
            counts.add(new LinkedHashSet<Integer>(set));
            return;
        }
        if (root.left!=null) {
            traverse(root.left, new LinkedHashSet<Integer>(set), counts);
        }
        if (root.right!=null) {
            traverse(root.right, new LinkedHashSet<Integer>(set), counts);
        }
        */
        if (root.left==null && root.right==null){
            counts.add(new LinkedHashSet<Integer>(set));
            return;
        }
        if (root.left!=null) {
            if (set.contains(root.left.val)){
                traverse(root.left, set, counts);
            }
            else {
                set.add(root.left.val);
                traverse(root.left, set, counts);
                set.remove(root.left.val);
            }
        }
        if (root.right!=null) {
            if (set.contains(root.right.val)){
                traverse(root.right, set, counts);
            }
            else {
                set.add(root.right.val);
                traverse(root.right, set, counts);
                set.remove(root.right.val);
            }
        }
    }
}