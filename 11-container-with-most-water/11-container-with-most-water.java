class Solution {
    public int maxArea(int[] height) {
        // always looking for highest two lines to contain water
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while(left <= right){
            maxWater = Math.max(maxWater, 
                                Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxWater;
    }
}