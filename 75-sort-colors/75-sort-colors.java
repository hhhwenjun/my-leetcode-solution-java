class Solution {
    public void sortColors(int[] nums) {
        // three-pointers solution:
        // 1. end of zero area, curr, start of two area
        // 2. swap to zero area, swap to two area
        int endZero = 0, curr = 0, startTwo = nums.length - 1;
        while(curr <= startTwo){
            if (nums[curr] == 0){
                swap(nums, curr, endZero);
                endZero++;
                curr++;
            }
            else if (nums[curr] == 2){
                swap(nums, curr, startTwo);
                startTwo--;
            }
            else curr++;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}