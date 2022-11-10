class Solution {
    public String removeDuplicates(String s) {
        // use a stack to store the letter 
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        stack.add(sArray[0]);
        for (int i = 1; i < sArray.length; i++){
            if (!stack.isEmpty() && sArray[i] == stack.peek()){
                stack.pop();
                continue;
            }
            stack.add(sArray[i]);
        }
        // use string builder, reverse the string
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}