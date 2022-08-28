class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numberSet = new HashSet<>();
        boolean happy = false;
        numberSet.add(n);
        int num = n;
        while(!happy){
            int sum = 0;
            while(num != 0){
                int digit = num % 10;
                sum += digit * digit;
                num = num / 10;
            }
            if (sum == 1) return true;
            if (numberSet.contains(sum)){
                return false;
            }
            numberSet.add(sum);
            num = sum;
        }
        return true;
    }
}