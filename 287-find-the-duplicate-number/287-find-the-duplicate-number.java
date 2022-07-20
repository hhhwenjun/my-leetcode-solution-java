class Solution {
    public int findDuplicate(int[] nums) {
        // 1. constant space: create a new array with size n, record occurence
        int[] count = new int[nums.length + 1];
        
        // 2. if occurence > 1, return the number
        for (int num : nums){
            count[num]++;
            if (count[num] > 1){
                return num;
            }
        }
        return -1;
    }
}