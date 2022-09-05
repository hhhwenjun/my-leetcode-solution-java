class Solution {
    public void sortColors(int[] nums) {
        // count the number of 0, 1, 2 in nums
        int zero = 0, one = 0, two = 0;
        for (int num : nums){
            if (num == 0){
                zero++;
            } else if (num == 1){
                one++;
            } else {
                two++;
            }
        }
        // modify the number based on order of 0, 1, 2 
        for (int i = 0; i < nums.length; i++){
            if (zero > 0){
                nums[i] = 0;
                zero--;
            }
            else if (one > 0){
                nums[i] = 1;
                one--;
            }
            else {
                nums[i] = 2;
                two--;
            }
        }
        
    }
}