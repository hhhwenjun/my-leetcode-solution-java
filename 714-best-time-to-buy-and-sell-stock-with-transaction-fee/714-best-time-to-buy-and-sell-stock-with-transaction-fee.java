class Solution {
    private int[] prices;
    private int[][] memo;
    private int fee;
    
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        // use dp:
        // two state variables: day, holding stock or not
        // two actions: buy, sell
        memo = new int[prices.length + 1][2];
        return dp(0, 0);
    }
    
    public int dp(int day, int holding){
        // base case: no profit
        if (day == prices.length){
            return 0;
        }
        // we find the cell has not been modified
        if (memo[day][holding] == 0){
            int doNothing = dp(day + 1, holding);
            int doSomething;
            
            // do something we have two actions
            // 1 - holding stock, 0 - does not hold
            if (holding == 1){
                // sell the stock?
                doSomething = prices[day] - fee + dp(day + 1, 0);
            }
            else {
                // buy a stock?
                doSomething = -prices[day] + dp(day + 1, 1);
            }
            memo[day][holding] = Math.max(doNothing, doSomething);
        }
        return memo[day][holding];
    }
}