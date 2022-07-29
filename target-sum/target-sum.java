class Solution {
    int[] nums;
    int target;
    int sum = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        // 1. return # expressions, all possible solutions, backtracking
        backtracking(0, target);
        return sum;
    }

    // 2. recursion: input - index, output: sum
    public void backtracking(int index, int target){
        // 3. if the end result reach the target, return +1 to the output
        // base case
        if (target == 0 && index == nums.length){
            sum++;
            return;
        }
        else if (index == nums.length){
            return;
        }
        // if target > 0, continue
        // for (int i = index; i < nums.length; i++){
            backtracking(index + 1, target + nums[index]);
            backtracking(index + 1, target - nums[index]);
        // }
    }
}