class Solution {
    /**
    * abstract: check the robot whether return to origin
    * 1. use two stacks represent horizontal/vertical directions
    * 2. when move, we add +1/-1 elements inside the stack
    * 3. determine all elements in the stack add up to 0
    */
    public boolean judgeCircle(String moves) {
        Stack<Integer> horizontal = new Stack<>();
        Stack<Integer> vertical = new Stack<>();
        
        for (char move : moves.toCharArray()){
            if (move == 'U'){
                vertical.add(1);
            }
            else if (move == 'D'){
                vertical.add(-1);
            }
            else if (move == 'L'){
                horizontal.add(1);
            }
            else if (move == 'R'){
                horizontal.add(-1);
            }
        }
        
        // count the sum of the two stacks, if 0 true, if != 0, false
        int sum = 0;
        for (Integer elem : horizontal){
            sum += elem;
        }
        if (sum != 0){
            return false;
        }
        for (Integer elem : vertical){
            sum += elem;
        }
        return sum == 0;
    }
}