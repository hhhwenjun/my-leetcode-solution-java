class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create hashmap to count the frequency and then use max-heap to return the entryset
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> countSet : map.entrySet()){
            maxheap.add(countSet);
        }
        for (int i = 0; i < k; i++){
            res[i] = maxheap.poll().getKey();
        }
        return res;
    }
}