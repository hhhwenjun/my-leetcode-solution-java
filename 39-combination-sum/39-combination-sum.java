class Solution {
    List<List<Integer>> res;
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        backtracking(0, target, new ArrayList<Integer>());
        return res;
    }
    
    // backtracking:
    // recursion, keep subtract target by the candidates, reach 0, find a combination
    public void backtracking(int start, int target, List<Integer> singleComb){
        // base case
        if (target == 0){
            res.add(new ArrayList(singleComb));
            return;
        }
        // base case: but not meet the requirement
        if (target < 0 || start == candidates.length){
            return;
        }
        for (int i = start; i < candidates.length; i++){
            singleComb.add(candidates[i]);
            backtracking(i, target - candidates[i], singleComb);
            singleComb.remove(singleComb.size() - 1);
        }
    }
}