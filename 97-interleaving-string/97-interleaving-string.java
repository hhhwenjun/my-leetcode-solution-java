class Solution {
    private String s1, s2, s3;
    private int[][] memo;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        // dp: state variables: s1, s2
        // create a 2D memo for recording states: true - 1, false - 0
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++){
            Arrays.fill(memo[i], -1);
        }
        return isInterleave(0, 0, 0);
    }
    
    public boolean isInterleave(int index1, int index2, int index3){
        // base case: reach to the end of either s1 or s2
        if (index1 == s1.length()){
            return s2.substring(index2).equals(s3.substring(index3));
        }
        if (index2 == s2.length()){
            return s1.substring(index1).equals(s3.substring(index3));
        }
        // check if we have memo about the current situation
        if (memo[index1][index2] != -1){
            return memo[index1][index2] == 1 ? true : false;
        }
        boolean res = false;
        // then we need to do something to fill the memo and connect with future string
        // connect with the next char in corresponding string, return boolean to determine results
        if (s3.charAt(index3) == s1.charAt(index1) && isInterleave(index1 + 1, index2, index3 + 1) ||
           s3.charAt(index3) == s2.charAt(index2) && isInterleave(index1, index2 + 1, index3 + 1)){
            memo[index1][index2] = 1;
            res = true;
        }
        else {
            memo[index1][index2] = 0;
        }
        return res;
    }
    
}