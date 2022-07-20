class Solution {
    public int maxProfit(int[] prices) {
        // 1. set min price as the first day price, max profit is 0
        // 2. each time in the pass compare the minprice and the max profit
        // 3. return the max profit
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        int benefit = 0;
        
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i]; // low price, no need to sell
                continue;
            }
            if (prices[i] - minPrice > max){
                max = prices[i] - minPrice;
                benefit = Math.max(benefit, max);
            }
        }
        return benefit;
    }
}