package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchCountOfSmallNumberdAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums==null||nums.length==0){
            return res;
        }
        res.add(0, 0);
        if (nums.length==1){
            return res;
        }
        if (nums[nums.length-1]<nums[nums.length-2]){
            res.add(0,1);
            int temp = nums[nums.length-1];
            nums[nums.length-1]=nums[nums.length-2];
            nums[nums.length-2]=temp;
        }
        else {
            res.add(0,0);
        }
        for (int i=nums.length-3;i>=0;i--){
            nums = sortFrom(nums, i+1);
            int bound = findLastLess(nums, i+1, nums[i]);
            res.add(0,bound-i);
        }
        return res;
    }
    public int[] sortFrom(int[] nums, int index){
        for (int i=index+1;i< nums.length;i++){
            if (nums[i]>=nums[index]){
                int temp = nums[index];
                int j = index;
                while (j<i-1){
                    nums[j]=nums[j+1];
                    j++;
                }
                nums[i-1] = temp;
                return nums;
            }
            if (nums[ nums.length-1]<nums[index]){
                int temp = nums[index];
                int j = index;
                while (j< nums.length-1){
                    nums[j]=nums[j+1];
                    j++;
                }
                nums[ nums.length-1] = temp;
                return nums;
            }
        }
        return nums;
    }
    public int findLastLess(int[] nums, int from, int target){
        int start = from;
        int end = nums.length-1;
        while (start!=end){
            int mid = start+(end-start)/2;
            if (nums[mid] < target){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return nums[start]>=target?start-1:start;
    }
    //my method
    //can use binary search tree to optimize

// Author: Huahua
// Running time: 10 ms
class HuahuaSolution {
    class Node {
      int val;
      int count;
      int left_count;
      Node left;
      Node right;
      public Node(int val) { 
          this.val = val; 
          this.count = 1; 
        }
      public int less_or_equal() { 
          return count + left_count; 
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0){
            return ans;
        }
        int n = nums.length;
        Node root = new Node(nums[n - 1]);
        ans.add(0);
        for (int i = n - 2; i >= 0; --i){
            ans.add(insert(root, nums[i]));
        } 
        Collections.reverse(ans);
        return ans;
    }
    
    private int insert(Node root, int val) {
        if (root.val == val) {
            ++root.count;
            return root.left_count;
        } 
        else if (val < root.val) {
            ++root.left_count;
            if (root.left == null) {
                root.left = new Node(val);            
                return 0;
            } 
            return insert(root.left, val);
        } 
        else {
            if (root.right == null) {
                root.right = new Node(val);
                return root.less_or_equal();
            }
            return root.less_or_equal() + insert(root.right, val);
        }
    }
} 
//use binary search tree to keep updating nodes' data
//return # of nodes with less value of current node as it added
//each node's data will keep updating after its result has been returned
}