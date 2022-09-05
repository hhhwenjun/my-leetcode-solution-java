class Solution {
    public boolean isHappy(int n) {
        // loops in a cycle: use hashset
        Set<Integer> set = new HashSet<>();
        int curr = n;
        while(curr != 1){
            if (set.contains(curr)) return false;
            set.add(curr);
            // calculate the sum of the squares
            int sum = 0;
            while(curr > 0){
                int digit = curr % 10;
                curr /= 10;
                sum += digit * digit;
            }
            curr = sum;
        }
        return true;
    }
}