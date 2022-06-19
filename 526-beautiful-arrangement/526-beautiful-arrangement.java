class Solution {
    // abstract: return number of arragements meet requirements
    // 1. Using backtracking, swap elements for permutations
    // 2. Determine if the permutation meets the requirements
    int count;
    List<Integer> nums;
    
    public int countArrangement(int n) {
        nums = new ArrayList<>();
        // put it inside an array
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }
        count = 0;
        backtracking(0);
        return count;
    }
    
    private boolean isBeautiful(int i, int j){
        return i % j == 0 || j % i == 0;
    }
    
    private void backtracking(int index){
        if (index == nums.size()){
            count++;
            return;
        }
        for (int i = index; i < nums.size(); i++){
            Collections.swap(nums, i, index);
            if (isBeautiful(nums.get(index), index + 1)){
                backtracking(index + 1);
            }
            Collections.swap(nums, i, index);
        }
    }
}