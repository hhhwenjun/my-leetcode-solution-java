class Solution {
    public int countVowelPermutation(int n) {
        if (n <= 0) return 0;
        // initialize the base case, when n = 1
        long aVowel = 1, eVowel = 1, iVowel = 1, oVowel = 1, uVowel = 1;
        long MOD = 1000000007;
        // given integer n, the length of vowel is n
        for (int i = 1; i < n; i++){
            // each time set the previous permutation number, add to the current number
            long aPreVowel = aVowel;
            long ePreVowel = eVowel;
            long iPreVowel = iVowel;
            long oPreVowel = oVowel;
            long uPreVowel = uVowel;
            
            // Sum up the vowel number to the current 
            aVowel = ePreVowel%MOD + uPreVowel%MOD + iPreVowel%MOD;
            eVowel = aPreVowel%MOD + iPreVowel%MOD;
            iVowel = ePreVowel%MOD + oPreVowel%MOD;
            oVowel = iPreVowel%MOD;
            uVowel = oPreVowel%MOD + iPreVowel%MOD;
        }
        long res = (aVowel%MOD + eVowel%MOD + iVowel%MOD + uVowel%MOD + oVowel%MOD)%MOD;
        return (int)res;
    }
}