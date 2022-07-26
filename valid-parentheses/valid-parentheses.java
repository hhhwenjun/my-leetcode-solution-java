class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        Stack<Character> charStack = new Stack<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        
        char[] parent = s.toCharArray();
        // loop through the string and store bracket
        for (Character bracket : parent){
            if (charMap.containsKey(bracket)){
                char top = charStack.isEmpty() ? '#' : charStack.pop();
                if (top != charMap.get(bracket)){
                    return false;
                }
            }
            else {
                charStack.push(bracket);
            }
        }
        return charStack.isEmpty();
    }
}