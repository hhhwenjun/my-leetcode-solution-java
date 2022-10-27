class Solution {
    int[] candidates;
    List<List<Integer>> list;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        this.candidates = candidates;
        backtracking(0, target, new ArrayList<Integer>());
        return list;
    }
    
    public void backtracking(int index, int target, List<Integer> subset){
        if (target == 0){
            list.add(new ArrayList(subset));
            return;
        }
        if (target < 0 || index == candidates.length){
            return;
        }
        // backtracking process
        for (int i = index; i < candidates.length; i++){
            subset.add(candidates[i]);
            backtracking(i, target - candidates[i], subset);
            subset.remove(subset.size() - 1);
        }
    }
}