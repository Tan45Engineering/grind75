import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.*/
public class _71WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //convert wordList to set for easier and faster lookup
        Set<String> wordSet = new HashSet<>(wordList);

        //base condition: check if endWord is in the worklist
        if(!wordSet.contains(endWord)){
            return 0; //transformation is not possible
        }

        //use biderectional BFS to find the shortest transformation sequence
        Set<String> beginSet = new HashSet<>(); //[hit, ]
        Set<String> endSet = new HashSet<>(); //[cog, ]
        Set<String> visited = new HashSet<>(); //[]

        beginSet.add(beginWord);
        endSet.add(endWord);

        //variable to track total steps/words/levels
        int level = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            //choose the smaller set
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for(String currentWord: beginSet){// hit
                char[] wordChars = currentWord.toCharArray();

                for(int i = 0; i < wordChars.length; i++){
                    //store original char
                    char originalChar = wordChars[i]; // h

                    for(char c = 'a'; c <= 'z'; c++){
                        if(wordChars[i] == c){
                            continue; //to skip
                        }

                        wordChars[i] = c;
                        String transformedWord = new String(wordChars); //ait

                        if(endSet.contains(transformedWord)){
                            return level + 1;//returning solution
                        }

                        if(wordSet.contains(transformedWord) && !visited.contains(transformedWord)){
                            nextLevel.add(transformedWord);
                            visited.add(transformedWord);
                        }
                    }
                    wordChars[i] = originalChar;

                }
            }

            beginSet = nextLevel;
            level++; //to calculate total steps/words/levels in the transformation
        }

        return 0; //no solution found
    }

    public static void main(String args[]){
        _71WordLadder obj = new _71WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(obj.ladderLength(beginWord, endWord,wordList));
    }
}
