class Solution {
    List<List<Integer>> res;
    List<Integer> nums;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = new ArrayList<Integer>();
        for (int num : nums) this.nums.add(num);
        res = new ArrayList<>();
        backtracking(0);
        return res;
    }
    
    public void backtracking(int index){
        if (index == nums.size()){
            res.add(new ArrayList(nums));
        }
        // backtracking process
        for (int i = index; i < nums.size(); i++){
            Collections.swap(nums, i, index);
            backtracking(index + 1);
            Collections.swap(nums, i, index);
        }
    }
}