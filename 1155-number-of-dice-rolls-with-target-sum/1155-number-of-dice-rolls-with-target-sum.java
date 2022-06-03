class Solution {
    Map<String, Integer> countMap = new HashMap<>();
    public int numRollsToTarget(int n, int k, int target) {
        long MOD = 1000000007;
        // the base cases
        if (target < n || n * k < target) return 0;
        if (n == 1) return (target <= k) ? 1 : 0;
        
        String key = n + " " + target;
        if (countMap.containsKey(key)){
            return countMap.get(key);
        }
        // if does not contain key
        int sum = 0;
        for (int i = 1; i <= k; i++){
            sum += numRollsToTarget(n - 1, k, target - i);
            sum %= MOD;
        }
        countMap.put(key, sum);
        return countMap.get(key);
    }
}