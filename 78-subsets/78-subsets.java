class Solution {
    int[] nums;
    List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        for (int k = 0; k < nums.length + 1; k++){
            backtracking(0, k, new ArrayList<Integer>());
        }
        return res;
    }
    
    public void backtracking(int index, int length, List<Integer> subset){
        if (subset.size() == length){
            res.add(new ArrayList(subset));
        }
        for (int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            backtracking(i + 1, length, subset);
            subset.remove(subset.size() - 1);
        }
    }
}