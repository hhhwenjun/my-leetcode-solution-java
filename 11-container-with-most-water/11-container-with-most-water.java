class Solution {
    public int maxArea(int[] height) {
        // always looking for highest two lines to contain water
        int max = 0;
        for (int i = 0, j= height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}