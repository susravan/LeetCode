package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 */

class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        char[] chrArr = prefix.toCharArray();
        for(int i=0; i < chrArr.length; i++) {
            if(!node.containsKey(chrArr[i])) {
               return null;
            }
            node = node.get(chrArr[i]);
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
}

class TrieNode {
    // R links to children
    private final int R = 26;
    private TrieNode[] next;
    private boolean isEnd;
    
    public TrieNode() {
        next = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return this.next[ch-'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return this.next[ch-'a'];
    }
    
    public void put(char ch, TrieNode node) {
        this.next[ch-'a'] = node;
    }
    
    public boolean isEnd() {
        return this.isEnd;
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
}
