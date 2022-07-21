class MyCircularQueue {
    
    private int[] queue;
    private int size;
    // two pointers to track the queue
    private int front;
    private int rear;
    private int capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (size >= capacity){
            return false;
        }
        // queue is empty
        if (size == 0){
            queue[rear] = value;
        }
        else {
            // in-case we pass the end or array(circular)
            rear = (rear + 1) % capacity;
            queue[rear] = value;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size <= 0){
            return false;
        }
        // only 1 element left in the queue
        if (rear == front){
            queue[rear] = 0;
        }
        else {
            queue[front] = 0;
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if (size <= 0){
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if (size <= 0){
            return -1;
        }
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */