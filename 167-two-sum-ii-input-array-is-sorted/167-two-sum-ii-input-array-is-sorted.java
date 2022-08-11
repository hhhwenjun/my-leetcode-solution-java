class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // the array is already sorted
        // two pointers to find the target
        int low = 0, high = numbers.length - 1;
        while(low < high){
            if (numbers[low] + numbers[high] < target){
                low++;
            }
            else if (numbers[low] + numbers[high] > target){
                high--;
            }
            else {
                return new int[]{low + 1, high + 1};
            }
        }
        return null;
    }
}