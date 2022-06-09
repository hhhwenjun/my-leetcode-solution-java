class Solution {
    List<List<Integer>> res;
    int[] nums;
    int k;
    
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        for (k = 0; k < nums.length + 1; k++){
            backtracking(0, new ArrayList<>());
        }
        return res;
    }
    
    public void backtracking(int start, List<Integer> subset){
        // base case
        if (subset.size() == k){
            res.add(new ArrayList(subset));
            return;
        }
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtracking(i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}