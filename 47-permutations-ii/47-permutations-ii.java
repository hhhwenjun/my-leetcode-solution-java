class Solution {
    /**
    * abstract: contain duplicates, return all permutations unique
    * Collections, swap, return list 
    * backtracking(recursion)
    */
    List<List<Integer>> res;
    Set<List<Integer>> uniquePermutations;
    List<Integer> nums;
    int length;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        length = nums.length;
        uniquePermutations = new HashSet<>();
        this.nums = new ArrayList<>();
        res = new ArrayList<>();
        // put nums in an array, so we can swap elements
        for (int num : nums){
            this.nums.add(num);
        }
        backtracking(0);
        return res;
    }
    
    // backtracking process
    public void backtracking(int start){
        // base case: reach the end of the array
        if (start == length && !uniquePermutations.contains(new ArrayList(nums))){
            res.add(new ArrayList(nums));
            uniquePermutations.add(new ArrayList(nums));
            return;
        }
        // backtracking and swap elements in nums list
        for (int i = start; i < length; i++){
            Collections.swap(nums, start, i);
            backtracking(start + 1);
            Collections.swap(nums, start, i);
        }
    }
}