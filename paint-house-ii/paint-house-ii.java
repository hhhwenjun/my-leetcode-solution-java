class Solution {
    
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        // loop through all the houses, calculate min costs sum for each house
        for (int i = 1; i < n; i++){
            for (int j = 0; j < k; j++){
                // find the optimal in the last row
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++){
                    if (j == l) continue;
                    if (costs[i - 1][l] < min){
                        min = costs[i - 1][l];
                    }
                }
                costs[i][j] += min;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++){
            if (minCost > costs[n - 1][j]){
                minCost = costs[n - 1][j];
            }
        }
        return minCost;
    }
}