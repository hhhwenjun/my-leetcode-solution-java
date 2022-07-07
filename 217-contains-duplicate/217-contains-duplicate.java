class Solution {
    public boolean containsDuplicate(int[] nums) {
        // set: cannot duplicate
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums){
            if (numSet.contains(num)){
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}