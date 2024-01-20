import java.util.Arrays;
import java.util.List;

/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".*/
public class _50WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Trie trie = new Trie();

        //Build the trie using the words from wordDict
        for(String str: wordDict){
            insert(str, trie);
        }
        return solve(s, trie, 0, dp);

    }

    //recursively call the function for backtracking
    private boolean solve(String s, Trie trie, int i, Boolean[] dp){
        //if we have reached the end of the string, it is a valid segmentation
        if(i == s.length()){
            return true;
        }

        //if the result for this index has alredy been calculated
        if(dp[i] != null){
            return dp[i];//memoization
        }

        Trie dict = trie;

        //iterate over the string startin from index i
        for(int j = i; j < s.length(); j++){
            dict = dict.a[s.charAt(j) - 'a'];

            //if the current character is not part of the trie, return false
            if(dict == null){
                return dp[i] = false;
            }

            //if we have reached the endOfWoed in the Trie, recursively call the solve method
            if(dict.endOfWord){
                if(solve(s, trie, j+1, dp)){
                    return true;
                }
            }
        }

        //solution does not exist on this path
        return dp[i] = false;
    }


    //method to insert word into Trie
    private void insert(String s, Trie trie){
        for(char ch: s.toCharArray()){
            if(trie.a[ch - 'a'] == null){
                trie.a[ch - 'a'] = new Trie();
            }
            trie = trie.a[ch - 'a'];
        }
        trie.endOfWord = true;
    }

    public static void main(String args[]){
        _50WordBreak obj = new _50WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(obj.wordBreak(s, wordDict));
    }
}

//Trie data structure definition
class Trie{
    Trie[] a; //Array for the next characters
    boolean endOfWord; //boolan flag to indicate end of the word

    //constructor
    public Trie(){
        a = new Trie[26];
        endOfWord = false;
    }
}
