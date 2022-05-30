class Solution {
    // hashmap: house, cost - two state variables
    private HashMap<String, Integer> memo = new HashMap<>();
    private int[][] costs;
    
    public int minCost(int[][] costs) {
        this.costs = costs;
        return Math.min(Math.min(paintCost(0, 0), paintCost(0, 1)), paintCost(0, 2));
    }
    
    // using recursion and dynamic programming to determine the cost
    public int paintCost(int day, int color){
        if (day == costs.length){
            return 0;
        }
        if (memo.containsKey(getKey(day, color))){
            return memo.get(getKey(day, color));
        }
        // the cost at current day and color
        int totalCost = costs[day][color];
        if (color == 0){
            // red color
            totalCost += Math.min(paintCost(day + 1, 1), paintCost(day + 1, 2));
        }
        else if (color == 1){
            // blue color
            totalCost += Math.min(paintCost(day + 1, 0), paintCost(day + 1, 2));
        }
        else {
            // green color
            totalCost += Math.min(paintCost(day + 1, 0), paintCost(day + 1, 1));
        }
        memo.put(getKey(day, color), totalCost);
        return totalCost;
    }
    
    // helper method to create key for the house
    public String getKey(int day, int color){
        return day + " " + color;
    }
}