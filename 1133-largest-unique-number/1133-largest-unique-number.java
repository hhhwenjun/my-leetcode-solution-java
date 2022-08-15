class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] dataMap = new int[1001];
        for (int num : nums){
            dataMap[num]++;
        }
        
        int largest = -1;
        for (int i = 0; i < dataMap.length; i++){
            if (dataMap[i] == 1){
                largest = i;
            }
        }
        return largest;
    }
}