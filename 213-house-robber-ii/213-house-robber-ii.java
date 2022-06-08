class Solution {

    public int rob(int[] nums) {
        // use house rubber solution twice
        // if edge cases
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int max1 = robHelper(nums, 0, nums.length - 2);
        int max2 = robHelper(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }
    
    // dynamic programming, memoization
    public int robHelper(int[] nums, int start, int end){
        int benefit1 = 0, benefit2 = 0;
        for (int i = start; i <= end; i++){
            int temp = benefit1;
            benefit1 = Math.max(nums[i] + benefit2, benefit1); // current - 1 day
            benefit2 = temp; // current - 2 day
        }
        return benefit1;
    }
}