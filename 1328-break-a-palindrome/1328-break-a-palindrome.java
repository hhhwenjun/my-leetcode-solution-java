class Solution {
    public String breakPalindrome(String palindrome) {
        // to break the palindrome, start from 1st location, change letter to 'a'
        // if the palindrome is all 'a', change the last letter to 'b'
        // since it is palindrome, only need to go to half way of string
        if (palindrome.length() <= 1) return "";
        int length = palindrome.length();
        char[] palinArray = palindrome.toCharArray();
        boolean isChanged = false;
        for (int i = 0; i < length/2; i++){
            if (palinArray[i] != 'a') {
                palinArray[i] = 'a';
                isChanged = true;
                break;
            }
        }
        if (!isChanged) palinArray[length - 1] = 'b';
        return String.valueOf(palinArray);
    }
}