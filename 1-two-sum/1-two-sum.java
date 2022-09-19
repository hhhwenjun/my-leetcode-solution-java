class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (myMap.get(target - nums[i]) != null)
            {
                result[0] = myMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
            myMap.put(nums[i], i);

        }
        
        
        
        
        return result;
        
    }
}