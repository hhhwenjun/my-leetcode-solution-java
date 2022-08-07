class Solution {
    public boolean isPalindrome(String s) {
        // two pointers
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while(low < high){
            char lowLetter = s.charAt(low);
            char highLetter = s.charAt(high);
            if (!Character.isLetterOrDigit(lowLetter)){
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(highLetter)){
                high--;
                continue;
            }
            if(lowLetter != highLetter) return false;
            low++;
            high--;
        }
        return true;
    }
}