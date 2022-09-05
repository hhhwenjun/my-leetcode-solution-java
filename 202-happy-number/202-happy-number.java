class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while(n != 1 && slow != fast){
            slow = next(slow);
            fast = next(next(fast));
        }
        return slow == 1;
    }
    
    public int next(int n){
        int curr = n;
        int sum = 0;
        while(curr > 0){
            int digit = curr % 10;
            curr /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}