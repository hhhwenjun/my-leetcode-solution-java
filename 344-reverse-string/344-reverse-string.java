class Solution {
    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;
        while(low < high){
            swap(s, low, high);
            low++;
            high--;
        }
    }
    
    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}