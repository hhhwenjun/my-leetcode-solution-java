class Solution {
    List<List<Integer>> res;
    Set<List<Integer>> findDuplicate;
    int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // backtracking: then use a set to find the duplicates
        Arrays.sort(nums);
        this.nums = nums;
        res = new ArrayList<>();
        findDuplicate = new HashSet<>();
        for (int i = 0; i < nums.length + 1; i++){
            backtracking(0, i, new ArrayList<Integer>());
        }
        return res;
    }
    
    public void backtracking(int index, int length, List<Integer> subset){
        if (subset.size() == length){
            res.add(new ArrayList(subset));
        }
        
        // backtracking
        for (int i = index; i < nums.length; i++){
            if (i != index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtracking(i + 1, length, subset);
            subset.remove(subset.size() - 1);
        }
    }
}