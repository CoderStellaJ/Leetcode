/*
Runtime: 77 ms, faster than 65.28% of Java online submissions for Implement Trie (Prefix Tree).
Memory Usage: 53.6 MB, less than 25.23% of Java online submissions for Implement Trie (Prefix Tree).

The data structure Trie (Prefix tree):
1. Complexity
Using trie has only O(m) time complexity, where m is the key length. 
Searching for a key in a balanced tree costs O(mlogn) time complexity where n is the number of keys inserted.
2. Details
Maximum of R links to its children, where each link corresponds to one of R character values from dataset alphabet. 
In this article we assume that R is 26, the number of lowercase latin letters.
Boolean field which specifies whether the node corresponds to the end of the key, or is just a key prefix.
*/
/////////////////////////////////////////////////////////////////////
class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    //O(m) where m is the key length
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    //search a prefix or whole key in trie and
    //returns the node where search ends
    //O(m) where m is the key length
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if(node.containsKey(curLetter)){
                node = node.get(curLetter);
            } else{
                return null;
            }
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    
    private class TrieNode {
        private TrieNode[] links;
        //final: const
        private final int R = 26;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch) {
            return links[ch-'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch-'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch-'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
