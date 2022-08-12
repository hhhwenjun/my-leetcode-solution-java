class Solution {
    public int numSteps(String s) {
        // if odd, add 1 carry to the next digit, two steps required
        // if even, only 1 step is required, no carry
        int count = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 1; i--){
            int rightMostBit = s.charAt(i) - '0';
            if ((rightMostBit + carry) == 1){
                carry = 1;
                count += 2;
            }
            else {
                count++;
            }
        }
        return count + carry;
    }
}