class Solution {
    int[] candidates;
    List<List<Integer>> list;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        list = new ArrayList<>();
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
        // backtracking
        for (int i = index; i < candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            subset.add(candidates[i]);
            backtracking(i + 1, target - candidates[i], subset);
            subset.remove(subset.size() - 1);
        }
    }
}