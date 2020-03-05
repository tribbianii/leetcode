package leetcode;

class ArrayProductofArrayExceptSelf {
    //solve it without division and in O(n).
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] lproduct = new int[nums.length];
        int[] rproduct = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lproduct[i] = i == 0 ? nums[i] : lproduct[i - 1] * nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            rproduct[j] = j == nums.length - 1 ? nums[nums.length - 1] : rproduct[j + 1] * nums[j];
        }
        for (int k = 1; k < nums.length - 1; k++) {
            result[k] = lproduct[k - 1] * rproduct[k + 1];
        }
        result[0] = rproduct[1];
        result[nums.length - 1] = lproduct[nums.length - 2];
        return result;
    }
    //follow-up: no extra space used
    public int[] ProductExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = i == 0 ? nums[i] : result[i - 1] * nums[i];
        }
        int rproduct = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] = j == 0 ? rproduct : result[j - 1] * rproduct;
            rproduct *= nums[j];
        }
        return result;
    }
}