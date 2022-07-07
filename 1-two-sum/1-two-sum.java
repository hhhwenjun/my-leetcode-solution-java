class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hashmap to store the value + index
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (numMap.containsKey(target - nums[i])){
                return new int[]{i, numMap.get(target - nums[i])};
            }
            if (!numMap.containsKey(nums[i])){
                numMap.put(nums[i], i);
            }
            
        }
        return new int[]{0, 0};
    }
}