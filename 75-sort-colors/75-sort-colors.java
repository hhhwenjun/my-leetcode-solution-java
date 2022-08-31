class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums){
            if (num == 0){
                zero++;
            } else if (num == 1){
                one++; 
            } else {
                two++;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if (zero != 0){
                nums[i] = 0;
                zero--;
            }
            else if (one != 0){
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