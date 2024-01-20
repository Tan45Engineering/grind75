/*A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]*/
public class _35ImplementTrie_PrefixTree {
    private TrieNode root;

    public _35ImplementTrie_PrefixTree() {
        //initialize the trie with an empty root node
        this.root = new TrieNode();
    }

    public void insert(String word) {
        //start from the root and insert each character fo the word into the trie
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.getChild(ch) == null){
                //if the child node doesn't exist, create a new node
                node.addChild(ch);
            }
            //move to the next level in the trie
            node = node.getChild(ch);
        }

        //mark the last node as the end of the inserted word
        node.setEndOfWord();
    }

    public boolean search(String word) {
        //start from the root and search for each character of the word in the trie
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.getChild(ch) == null){
                //if the character is not found, return false
                return false;
            }

            //move to the next level in the trie
            node = node.getChild(ch);
        }

        //check if the last node represent the end of the word
        return node.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        //start form the root and search for each charater of the prefix
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            if(node.getChild(ch) == null){
                //if the character is not found, return false
                return false;
            }

            //move to the next level
            node = node.getChild(ch);
        }
        //the prefix is present in the trie
        return true;
    }
}

class TrieNode {
    //each trieNode represents a character in the trie
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode(){
        //initialize the trieNode with an array of children (26 letters) and set isEndOfWrod as false
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    public TrieNode addChild(char ch){
        //create a new child node for the character ch
        TrieNode newNode = new TrieNode();
        children[ch - 'a'] = newNode;
        return newNode;
    }

    public TrieNode getChild(char ch){
        //get the child node corresponding to the character ch
        return children[ch - 'a'];
    }

    public boolean isEndOfWord(){
        //check if the current node represents the end of the word
        return isEndOfWord;
    }

    public void setEndOfWord(){
        //mark the current node as the end of the word
        isEndOfWord = true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
