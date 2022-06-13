class Solution {
    /**
    * abstract: return all permutations, unique number, return in list
    * backtracking algorithm(recursion) 
    */
    List<List<Integer>> res;
    List<Integer> nums;
    int length;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = new ArrayList<>();
        res = new ArrayList<>();
        for (int num : nums){
            this.nums.add(num);
        }
        length = nums.length;
        backtracking(0);
        return res;
    }
    
    // backtracking process realization
    public void backtracking(int start){
        // base case: reach the end of given nums
        if (start == length){
            // add the current permutation to result list
            res.add(new ArrayList(nums));
            return;
        }
        for (int i = start; i < length; i++){
            Collections.swap(nums, start, i);
            backtracking(start + 1);
            Collections.swap(nums, start, i);
        }    
    }
}