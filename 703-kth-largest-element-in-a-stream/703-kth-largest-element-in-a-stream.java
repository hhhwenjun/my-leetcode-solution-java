class KthLargest {
    
    PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> a - b);
    int capacity = 0;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        for (int num : nums){
            maxheap.add(num);
            if (maxheap.size() > capacity){
                maxheap.poll();
            }
        }
    }
    
    public int add(int val) {
        maxheap.add(val);
        if (maxheap.size() > capacity) maxheap.poll();
        return maxheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */