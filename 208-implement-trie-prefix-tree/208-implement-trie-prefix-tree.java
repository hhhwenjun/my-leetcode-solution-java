class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    // insert a word into trie
    // Time complexity : O(m), where m is the key length.
    // Space complexity : O(m).
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    
    // search prefix can be applied in search, but need to check isEnd
    // Time complexity : O(m) In each step of the algorithm we search for the next key character.
    // Space complexity : O(1)
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currLetter = word.charAt(i);
            if (node.containsKey(currLetter)){
                node = node.get(currLetter);
            }
            else {
                return null;
            }
        }
        return node;
    }
    
    // apply the previous method
    // Time complexity : O(m)
    // Space complexity : O(1)
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode {
    // R links to node children
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */