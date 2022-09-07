class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int[] sumList = new int[nums.length];
        sumList[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            sumList[i] = Math.max(nums[i], sumList[i - 1] + nums[i]);
            largestSum = Math.max(largestSum, sumList[i]);
        }
        return largestSum;
    }
}