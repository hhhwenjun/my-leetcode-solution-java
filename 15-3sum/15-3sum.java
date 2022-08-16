class Solution {
    // two pointers
    // 1. sum to 0: location < 0
    // 2. low and high pointer
    List<List<Integer>> res;
    int[] nums;
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        this.nums = nums;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            // in case duplicate situations
            if (i == 0 || nums[i - 1] != nums[i]){
                findSolution(i);
            }
        }
        return res;
    }
    
    public void findSolution(int loc){
        
        int low = loc + 1, high = nums.length - 1;
        while(low < high){
            int sum = nums[low] + nums[high] + nums[loc];
            if (sum == 0){
                res.add(Arrays.asList(nums[loc], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low - 1]){
                    low++;
                }
            }
            else if (sum < 0){
                low++;
            }
            else {
                high--;
            }
        }
    }
}