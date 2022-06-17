class Solution {
    int[] candidates;
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        res = new ArrayList<>();
        
        // use backtracking solution
        backtracking(0, target, new ArrayList<>());
        return res;
    }
    
    // realize the backtracking process
    public void backtracking(int index, int target, List<Integer> singleResult){
        // base case: reach target
        if (target == 0){
            res.add(new ArrayList(singleResult));
            return;
        }
        
        // other base case: reach the end of given array or cannot get target
        if (target < 0 || index == candidates.length){
            return;
        }
        
        // backtracking core
        for (int i = index; i < candidates.length; i++){
            singleResult.add(candidates[i]);
            backtracking(i, target - candidates[i], singleResult);
            singleResult.remove(singleResult.size() - 1);
        }
    }
}