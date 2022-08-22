class Solution {
    public String longestPalindrome(String s) {
        // expand around center
        if (s == null || s.equals("")) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    public int expandAroundCenter(String s, int start, int end){
        int left = start, right = end;
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}