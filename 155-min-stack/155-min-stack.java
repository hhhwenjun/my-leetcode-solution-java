class MinStack {
    Deque<Integer> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
    }
    
    public void pop() {
        stack.removeLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        List<Integer> temp = new LinkedList<>(stack);
        Collections.sort(temp);
        return temp.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */