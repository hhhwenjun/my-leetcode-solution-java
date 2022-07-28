class Solution {
    int n;
    List<String> res;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new ArrayList<>();
        backtracking(new StringBuilder(), 0, 0);
        return res;
    }
    
    // 1. backtracking method, use "open" and "close" to record number of them
    // 2. prefer to put open parenthese, but if close < open, put close
    // 2. remove the newly added parenthese
    public void backtracking(StringBuilder str, int open, int close){
        // base case, number reach max
        if (str.length() == 2 * n){
            res.add(str.toString());
        }
        // backtrack
        if (open < n){
            str.append("(");
            backtracking(str, open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open){
            str.append(")");
            backtracking(str, open, close + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}