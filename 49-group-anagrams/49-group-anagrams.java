class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        
        // use a hashmap to store the key and list of strings
        // key: count of each character is string
        Map<String, List<String>> res = new HashMap<>();
        
        int[] letter = new int[26];
        for (String str : strs){
            Arrays.fill(letter, 0);
            // count the occurrence of each char
            for (char ch : str.toCharArray()) letter[ch - 'a']++;
            StringBuilder key = new StringBuilder();
            for (int occr : letter) {
                key.append("#");
                key.append(occr);
            }
            
            // put it to the hashmap
            String keyStr = key.toString();
            if (!res.containsKey(keyStr)){
                res.put(keyStr, new ArrayList<String>());
            }
            res.get(keyStr).add(str);
        }
        return new ArrayList(res.values());
    }
}