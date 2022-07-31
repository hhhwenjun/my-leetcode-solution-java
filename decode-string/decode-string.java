class Solution {
    public String decodeString(String s) {
        // stack: find ']' then start to pop elements from stack
        // 1. create a stack, store char, put all elements to stack
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        
        
        for (char ch : sArray){
            if (ch != ']'){
                stack.add(ch);
                continue;
            }
            // 2. when put element, if find ']', start to pop
            StringBuilder currString = new StringBuilder();
            while(!stack.isEmpty()){
                char curr = stack.pop();
                // 3. until we pop '[' and k, repeat k times of curr string
                if (curr == '['){
                    break;
                }
                currString.append(curr);
            }
            
            currString = currString.reverse();
            String pattern = currString.toString();
            StringBuilder times = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() - '0' < 10){
                times.append(stack.pop());
            }
            int time = Integer.parseInt(times.reverse().toString());
            for (int i = 1; i < time; i++){
                currString.append(pattern);
            }
            String repeat = currString.toString();
            // 4. put the string(chars) back to stack
            for (char newch : repeat.toCharArray()){
                stack.add(newch);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}