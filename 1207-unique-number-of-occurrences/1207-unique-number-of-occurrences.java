class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // use hashmap to count the occurences
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> reverseCountMap = new HashMap<>();
        
        for (int num : arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entrySet : countMap.entrySet()){
            // count as key, num as value, check if duplicate key
            if (reverseCountMap.containsKey(entrySet.getValue())){
                return false;
            }
            reverseCountMap.put(entrySet.getValue(), entrySet.getKey());
        }
        return true;
    }
}