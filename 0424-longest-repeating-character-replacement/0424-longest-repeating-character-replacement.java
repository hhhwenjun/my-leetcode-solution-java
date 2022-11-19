class Solution {
    public int characterReplacement(String s, int k) {
        // smallest window size is 1
        int lo = 1;
        int hi = s.length() + 1; // invalid window size
        
        // within normal window size
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            
            // can we make a valid substring of mid window size
            if (canMakeValidSubstring(s, mid, k)){
                lo = mid;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
    
    private boolean canMakeValidSubstring(String s, int windowLength, int k){
        int[] freqMap = new int[26];
        int maxFrequency = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++){
            freqMap[s.charAt(end) - 'A']++;
            
            // at the end of the window size
            if (end + 1 - start > windowLength){
                freqMap[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end) - 'A']);
            if (windowLength - maxFrequency <= k){
                return true;
            }
        }
        return false;
    }
}