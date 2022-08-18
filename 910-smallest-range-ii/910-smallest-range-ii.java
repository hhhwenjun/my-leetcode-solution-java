class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        int ans = nums[length - 1] - nums[0]; // the largest range

        for (int i = 0; i < length - 1; i++){
            int a = nums[i], b = nums[i + 1];
            int high = Math.max(nums[length - 1] - k, a + k);
            int low = Math.min(nums[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}