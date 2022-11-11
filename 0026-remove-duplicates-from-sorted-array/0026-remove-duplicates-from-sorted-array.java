class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointers and swap the data
        int slow = 0, fast = 1;
        while(fast < nums.length){
            if (nums[fast] == nums[fast - 1]){
                fast++;
                continue;
            }
            // swap to slow position
            nums[++slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }
}