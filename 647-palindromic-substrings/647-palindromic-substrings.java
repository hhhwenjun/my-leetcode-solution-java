class Solution {
    // backtracking: each time find a combination, and check if it is palindrome
    public int countSubstrings(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++){
            ans += countPalindromeAroundCenter(s, i, i);
            ans += countPalindromeAroundCenter(s, i, i + 1);
        }
        return ans;
    }
    
    private int countPalindromeAroundCenter(String str, int low, int high){
        int ans = 0;
        while (low >= 0 && high < str.length()){
            if (str.charAt(low) != str.charAt(high)) break; // not palindrome
            low--;
            high++;
            ans++;
        }
        return ans;
    }
}