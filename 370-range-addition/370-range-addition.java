class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] update : updates){
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            
            for (int i = start; i <= end; i++){
                nums[i] += inc;
            }
        }
        return nums;
    }
}