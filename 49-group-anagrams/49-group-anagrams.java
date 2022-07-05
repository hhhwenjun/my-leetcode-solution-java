class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        // pattern (int[26]), list of strings, to count the occurence of letters
        
        Map<String, List<String>> pattern = new HashMap<>();
        for (String str : strs){
            int[] countMap = new int[26];
            for (char ch : str.toCharArray()){
                countMap[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++){
                key.append("#");
                key.append(countMap[i]);
            }
            String keyString = key.toString();
            if (!pattern.containsKey(keyString)){
                pattern.put(keyString, new ArrayList<>());
            }
            // meet the pattern, they should be grouped and put in result list
            pattern.get(keyString).add(str);
        }
        
        // loop the map and store the string list to result list
        for (Map.Entry<String, List<String>> entry : pattern.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}