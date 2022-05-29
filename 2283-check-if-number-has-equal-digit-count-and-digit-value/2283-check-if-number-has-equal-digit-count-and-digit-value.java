class Solution {
    public boolean digitCount(String num) {
        // brute force
        int n = num.length();
        int count = 0;
        char[] charArry = num.toCharArray();
        for (int i = 0; i < n; i++){
            count = 0;
            int expect = Character.getNumericValue(charArry[i]);
            for (int j = 0; j < n; j++){
                int current = Character.getNumericValue(charArry[j]);
                if (current == i){
                    count++;
                }
            }
            if (count != expect){
                return false;
            }
        }
        return true;
    }
}