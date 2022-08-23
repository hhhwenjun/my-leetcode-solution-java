class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointer + hashmap
        // 1. create a hashmap, store the number of char
        Map<Character, Integer> indexMap = new HashMap<>();
        
        if (s.length() < 1) return 0;
        
        // 2. loop through the string, two pointers form a window
        int low = 0, high = 0;
        int longest = 0;
        while(high < s.length()){
            indexMap.put(s.charAt(high), indexMap.getOrDefault(s.charAt(high), 0) + 1);
            
            while (indexMap.get(s.charAt(high)) > 1){
                indexMap.put(s.charAt(low), indexMap.get(s.charAt(low)) - 1);
                low++;
            }
            
            longest = Math.max(longest, high - low + 1);
            high++;
        }
        return longest;
    }
}