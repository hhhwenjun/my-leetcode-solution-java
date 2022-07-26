class MinStack {
    
    private Deque<int[]> list;

    public MinStack() {
        list = new LinkedList<>();
    }
    
    public void push(int val) {
        if (list.isEmpty()) list.addFirst(new int[]{val, val});
        else {
            list.addFirst(new int[]{val, Math.min(val, list.peekFirst()[1])});
        }
    }
    
    public void pop() {
        list.removeFirst();
    }
    
    public int top() {
        return list.peekFirst()[0];
    }
    
    public int getMin() {
        return list.peekFirst()[1];
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