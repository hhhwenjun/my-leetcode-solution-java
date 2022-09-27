class Solution {
    
    private class LargeNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    
    public String largestNumber(int[] nums) {
        // get input integers as strings
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        
        // sort strings according to custom comparator
        Arrays.sort(strs, new LargeNumberComparator());
        
        // if, after being sorted, the largest number is 0,
        // the entire number is 0.
        if (strs[0].equals("0")) return "0";
        
        // build largest number from sorted array
        String largestNumberStr = new String();
        for (String numStr : strs){
            largestNumberStr += numStr;
        }
        return largestNumberStr;
    }
}