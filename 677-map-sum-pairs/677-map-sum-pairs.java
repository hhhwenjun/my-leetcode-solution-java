class TrieNode {
    public Map<Character, TrieNode> children;
    public int score;
    
    public TrieNode() {
        children = new HashMap<>();
        score = 0;
    }
}

class MapSum {
    // trie data structure
    public TrieNode root;
    public Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode curr = root;
        curr.score += delta;
        for (int i = 0; i < key.length(); i++){
            char currLetter = key.charAt(i);
            curr.children.putIfAbsent(currLetter, new TrieNode());
            curr = curr.children.get(currLetter);
            curr.score += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()){
            curr = curr.children.get(c);
            if (curr == null) return 0;
        }
        return curr.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */