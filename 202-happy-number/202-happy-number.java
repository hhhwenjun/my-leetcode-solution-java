class Solution {
    public boolean isHappy(int n) {
        // unhappy number ends in a cycle
        // detect cycle by hare and turtle algorithm
        int slow = n, fast = sumOfSquares(sumOfSquares(n));
        while(n != 1 && slow != fast){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return slow == 1;
    }
    
    public int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            // get the digit of n
            int digit = n % 10;
            sum += digit * digit;
            // get the next digit of n
            n /= 10;
        }
        return sum;
    }
}