class Solution {
    public int evalRPN(String[] tokens) {
        // use a stack, each time encounter a math operator, 
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens){
            
            // we poll two elements from stack, and put result back to stack
            if (token.equals("+")){
                int curr1 = stack.pop();
                int curr2 = stack.pop();
                stack.add(curr1 + curr2);
            }
            else if (token.equals("*")){
                int curr1 = stack.pop();
                int curr2 = stack.pop();
                stack.add(curr1 * curr2);
            }
            else if (token.equals("/")){
                int curr1 = stack.pop();
                int curr2 = stack.pop();
                stack.add(curr2 / curr1);
            }
            else if (token.equals("-")){
                int curr1 = stack.pop();
                int curr2 = stack.pop();
                stack.add(curr2 - curr1);
            }
            else {
                // ch is a number
                int currNum = Integer.parseInt(token);
                stack.add(currNum);
            }
        }
        
        // check stack when it is only 1 element left in stack
        return stack.size() == 1 ? stack.pop() : -1;
    }
}