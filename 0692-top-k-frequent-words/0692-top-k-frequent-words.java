class Solution {
    class Pair<O,K>{
        O first;
        K second;
        
        public Pair(O o, K k){
            first = o;
            second = k;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Pair<String, Integer> pair1, Pair<String, Integer> pair2){
                if (pair1.second == pair2.second){
                    return pair1.first.compareTo(pair2.first);
                }
                return pair2.second - pair1.second;
            }
        });
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            Pair<String, Integer> currPair = new Pair(entry.getKey(), entry.getValue());
            queue.add(currPair);
        }
        // use array list to store the result
        List<String> res = new ArrayList<>();
        while(k > 0){
            res.add(queue.poll().first);
            k--;
        }
        return res;
    }
}