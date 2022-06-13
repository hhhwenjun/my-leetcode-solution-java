class Solution {
    /*
    * abstract: build expression, return all number of expressions
    * Use all num in nums, reach the target sum
    * backtracking(recursion)
    */
    int res;
    int[] nums;
    
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        this.nums = nums;
        backtracking(0, target);
        return res;
    }
    
    // backtracking process
    public void backtracking(int index, int target){
        // base case: reach the end of nums
        if (index == nums.length && target == 0){
            res++;
            return;
        }
        if (index == nums.length){
            return;
        }
        // expressions building, can be +/-
        backtracking(index + 1, target + nums[index]);
        backtracking(index + 1, target - nums[index]); 
    }
}