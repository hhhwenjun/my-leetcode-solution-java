class Solution {
    /**
    * Abstract info: k number, sum to n, unique number, 1 - 9
    * Question: return all valid combinations, return as List<List<Integer>>
    * Possible method: Backtracking(recursion)
    */
    
    // all the fields we need for backtracking
    int k;
    int n;
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        res = new ArrayList<>();
        backtracking(0, 0, new ArrayList<Integer>(), n);
        return res;
    }
    
    // backtracking algorithm
    public void backtracking(int numberOfElem, int start, List<Integer> singleComb, int target){
        // base case
        if (numberOfElem == k && target == 0){
            res.add(new ArrayList(singleComb));
            return;
        }
        if (numberOfElem == k || target < 0){
            return;
        }
        // element range from 1 - 9
        for (int i = start + 1; i < 10; i++){
            singleComb.add(i);
            backtracking(numberOfElem + 1, i, singleComb, target - i);
            singleComb.remove(singleComb.size() - 1);
        }
    }
}