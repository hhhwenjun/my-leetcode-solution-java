class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums){
            heap.add(num);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}