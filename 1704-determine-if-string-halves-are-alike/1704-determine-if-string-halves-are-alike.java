class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a'); vowel.add('e'); vowel.add('i');
        vowel.add('o'); vowel.add('u'); vowel.add('A');
        vowel.add('E'); vowel.add('I'); vowel.add('O'); vowel.add('U');
        
        // then split the s to two strings and count the vowels
        int length = s.length();
        char[] sArray = s.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        
        for (int i = 0; i < length / 2; i++){
            if (vowel.contains(sArray[i])){
                leftCount++;
            }
        }
        
        for (int i = length / 2; i < length; i++){
            if (vowel.contains(sArray[i])){
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }
}