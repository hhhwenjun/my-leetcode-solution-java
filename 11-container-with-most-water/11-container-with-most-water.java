class Solution {
    public int maxArea(int[] height) {
        // two pointers:
        // 1. low, high: calcualte the area of container
        int low = 0, high = height.length - 1;
        int maxArea = 0;
        
        // 2. if one pointer < another, move the pointer
        while(low < high){
            int currArea = (high - low)*Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, currArea);
            if (height[low] < height[high]){
                low++;
            }
            else {
                high--;
            }
        }
        // 3. until the low and high pointer meets
        return maxArea;
    }
}