class Solution {
    
    private Map<Character, Character> parenMap = new HashMap<>();
    
    public boolean isValid(String s) {
        // 1. create a stack to store char in string
        parenMap.put(')', '(');
        parenMap.put('}', '{');
        parenMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        
        // 2. each time we find ) we pop the element in stack
        for (char ch : s.toCharArray()){
            if (!parenMap.containsKey(ch)){
                stack.add(ch);
            }
            else {
                if (stack.isEmpty()) return false;
                char curr = stack.pop();
                char pair = parenMap.get(ch);
                if (curr != pair) return false;
            }
        }
        // 3. if the pop element is not the supposed half bracket, return false
        return stack.isEmpty();
    }
}