class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++){
            int accu = 1;
            for (int j = i; j < nums.length; j++){
                accu *= nums[j];
                res = Math.max(accu, res);
            }
        }
        return res;
    }
}