class Solution {
    public int trap(int[] height) {
        // two pointers： low, high
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;
        
        while(left < right){
            // current right pointer is max right
            // 1. compare two pointer, always keep the high one
            if (height[left] < height[right]){
                if (height[left] >= maxLeft){
                    maxLeft = height[left];
                } 
                else water += maxLeft - height[left];
                // 2. move the lower pointer, record left and right max
                left++;
            }
            else {
                 // 3. when move the lower one, record max - low value
                if (height[right] >= maxRight){
                    maxRight = height[right];
                }
                else water += maxRight - height[right];
                right--;
            }
        }
        return water;
        
       
    }
}