package leetcode;

class ArrayProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        //product from right to left
        for (int j = nums.length - 1; j >= 0; j --) {
            res[j] = j < nums.length - 1 ? nums[j] * res[j + 1] : nums[j];
        }
        //product from left to right
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = i > 0 ? nums[i - 1] *  nums[i] : nums[i];
        }
        //product except self
        for (int k = 0; k < nums.length; k ++) {
            res[k] = (k == 0 ? 1 : nums[k - 1]) * (k == nums.length - 1 ? 1 : res[k + 1]);
        }
        return res;
    }
}