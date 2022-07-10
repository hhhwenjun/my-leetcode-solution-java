class Solution {
    public String alienOrder(String[] words){
    
	// step 0: create data structures and find all unique letters
    Map<Character, List<Character>> adjList = new HashMap<>();
    // count indegree of char
    Map<Character, Integer> counts = new HashMap<>();
    // initialize the map and list
    for (String word : words){
        for (char c : word.toCharArray()){
            counts.put(c, 0);
            adjList.put(c, new ArrayList<>());
        }
    }
    
    // step 1: find all edges in graph
    for (int i = 0; i < words.length - 1; i++){
        // compare the adjacent words
        String word1 = words[i];
        String word2 = words[i + 1];
        // check that word 2 is not a prefix of word1
        if (word1.length() > word2.length() && word1.startsWith(word2)){
            return "";
        }
        // find the first non match and insert the corresponding relation
        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++){
            if (word1.charAt(j) != word2.charAt(j)){
                // directed graph, prerequisite char -> next char, add to indegree
                adjList.get(word1.charAt(j)).add(word2.charAt(j));
                counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                break;
            }
        }
    }
    
    // step 2: bfs
    StringBuilder sb = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    for (Character c : counts.keySet()){
        // first reachable char
        if (counts.get(c).equals(0)){
            queue.add(c);
        }
    }
    while(!queue.isEmpty()){
        Character c = queue.remove();
        sb.append(c);
        // find adjacent list
        for (Character next : adjList.get(c)){
            counts.put(next, counts.get(next) - 1); // minus indegree
            if (counts.get(next).equals(0)){
                queue.add(next);
            }
        }
    }
    if (sb.length() < counts.size()){
        return ""; // some cannot be determined
    }
    return sb.toString();
}
}