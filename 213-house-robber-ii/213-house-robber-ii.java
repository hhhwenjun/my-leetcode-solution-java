class Solution {
    public int rob(int[] nums) {
        // edge cases, no house or only 1 house
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // either start on 0th house or the 1st house
        int sum1 = robMoney(nums, 0, nums.length - 2);
        int sum2 = robMoney(nums, 1, nums.length - 1);
        return Math.max(sum1, sum2);
    }
    
    public int robMoney(int[] nums, int start, int end){
        int gain1 = 0, gain2 = 0;
        int temp = 0;
        
        for (int i = start; i <= end; i++){
            temp = gain1;
            gain1 = Math.max(nums[i] + gain2, gain1);
            gain2 = temp;
        }
        return gain1;
    }
}