class StockSpanner {
    // use two stacks for computation:
    // stack 1: only for storage
    // stack 2: copy stack 1, deduct the number until empty or larger than current
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        // stack2 = (Stack<Integer>)stack1.clone(); // clone would take lots of time here
        int ans = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            ans += stack.pop()[1];
        }
        stack.push(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */