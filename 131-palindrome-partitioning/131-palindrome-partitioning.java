class Solution {
    List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        // boolean memoization
        res = new ArrayList<List<String>>();
        partition(s, 0, new ArrayList<String>());
        return res;
    }
    
    // helper method to partition the words
    public void partition(String s, int start, List<String> currentList){
        if (start >= s.length()){
            res.add(new ArrayList<String>(currentList));
        }
        for (int end = start; end < s.length(); end++){
            if (isPalindrome(s.substring(start, end + 1))){
                currentList.add(s.substring(start, end + 1));
                partition(s, end + 1, currentList);
                // backtrack and remove the current result
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    
    // helper method, check if the word is palindrome
    public boolean isPalindrome(String s){
        // two pointers
        int low = 0, high = s.length() - 1;
        while (low < high){
            if (s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}