class Solution {
    public double myPow(double x, int n) {
        long times = n;
        if (times < 0) {
            x = 1 / x;
            times = -times;
        }
        double ans = 1;
        double current_product = x;
        for (long i = times; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}