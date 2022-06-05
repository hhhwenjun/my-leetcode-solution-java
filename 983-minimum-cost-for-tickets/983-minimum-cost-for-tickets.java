class Solution {
    private Set<Integer> daySet;
    private int[] costs;
    private Integer[] memo;
    
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        daySet = new HashSet<>();
        // day number is non-duplicated
        for (int day : days){
            daySet.add(day);
        }
        return dp(1);
    }
    
    public int dp(int day){
        // base case of recursion
        if (day > 365) return 0;

        if (memo[day] != null){
            return memo[day];
        }
        int ans = 0;
        if (daySet.contains(day)){
            ans = Math.min(dp(day + 1) + costs[0],
                           Math.min(dp(day + 7) + costs[1],
                                   dp(day + 30) + costs[2]));
        }
        else {
            ans = dp(day + 1); // no need to travel today
        }
        memo[day] = ans;
        return ans;
    }
}