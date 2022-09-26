class Solution {
    public int[] plusOne(int[] digits) {
        // all you need to check is the last digit see if it is 9
        int length = digits.length;
        if (digits[length - 1] != 9){
            digits[length - 1]++;
            return digits;
        }
        
        // if is 9, need to go through other digits
        // +1 then carry 1 over to previous digits
        int loc = length - 1;
        while(loc >= 0 && digits[loc] == 9){
            digits[loc] = 0;
            loc--;
        }
        if (loc >= 0) {
            digits[loc]++;
            return digits;
        }
        
        // create a new array
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}