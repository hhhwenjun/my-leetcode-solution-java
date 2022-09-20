class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones){
            stoneHeap.add(stone);
        }
        
        while(stoneHeap.size() > 1){
            int stone1 = stoneHeap.poll();
            int stone2 = stoneHeap.poll();
            int res = Math.abs(stone1 - stone2);
            if (res != 0){
                stoneHeap.add(res);
            }
        }
        return stoneHeap.size() == 0 ? 0 : stoneHeap.poll();
    }
}