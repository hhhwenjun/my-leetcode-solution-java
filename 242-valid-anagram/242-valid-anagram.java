class Solution {
    // sum: return if is anagram
    public boolean isAnagram(String s, String t) {
        // 1. compare length of the string, if not same length, false
        if (s.length() != t.length()) return false;
        
        // 2. use an array to store the occurence of letter in 1 string
        int[] occurence = new int[26]; // lower cases
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        for (char ch : sArray){
            int loc = ch - 'a';
            occurence[loc]++;
        }
        
        // 3. subtract the occrence in the array base on 2 string, if every letter go back to 0, true
        for (char ch : tArray){
            int loc = ch - 'a';
            occurence[loc]--;
        }
        
        for (int count : occurence){
            if (count != 0){
                return false;
            }
        }
        return true;
    }
}