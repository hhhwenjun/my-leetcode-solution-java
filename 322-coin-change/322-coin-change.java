class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinAmount = new int[amount];
        return coinChange(coins, amount, coinAmount);
    }
    
    public int coinChange(int[] coins, int amount, int[] coinAmount){
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (coinAmount[amount - 1] != 0) return coinAmount[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = coinChange(coins, amount - coin, coinAmount);
            if (min > res && res != -1){
                min = 1 + res;
            }
        }
        coinAmount[amount - 1] = (min == Integer.MAX_VALUE)?-1:min;
        return coinAmount[amount - 1];
    }
}