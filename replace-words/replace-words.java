class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode(){
        children = new TrieNode[26];
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // use a trie structure to store prefix to trie
        TrieNode trie = new TrieNode();
        for (String prefix : dictionary){
            TrieNode curr = trie;
            for (char letter : prefix.toCharArray()){
                // create a children trienode
                if (curr.children[letter - 'a'] == null){
                    curr.children[letter - 'a'] = new TrieNode();
                }
                curr = curr.children[letter - 'a'];
            }
            curr.word = prefix;
        }
        
        // construct a new string to return 
        StringBuilder res = new StringBuilder();
        
        for (String word : sentence.split("\\s+")){
            if (res.length() > 0) res.append(" "); 
            
            TrieNode curr = trie;
            for (char letter : word.toCharArray()){
                if (curr.children[letter - 'a'] == null || curr.word != null){
                    break;
                }
                curr = curr.children[letter - 'a'];
            }
            res.append(curr.word != null ? curr.word : word);
        }
        return res.toString();
    }
}