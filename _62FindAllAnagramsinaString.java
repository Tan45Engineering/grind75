import java.util.ArrayList;
import java.util.List;

/*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/
public class _62FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        //check if either s or p is empty
        if(s == null || p == null || s.length() == 0 || p.length() == 0){
            return result;
        }

        //frequeuncy array for characters
        int[] charCount = new int[26];
        int pLength = p.length();

        //populate the frequency array for string p
        for(char c : p.toCharArray()){
            charCount[c - 'a']++;
        }

        //initialize the sliding window
        int left = 0;
        int right = 0;

        //iterate through string s
        while(right < s.length()){
            //decrease the count of the current charater in the window
            charCount[s.charAt(right) - 'a']--;

            if(right - left + 1 == pLength){
                //check if the charCount array is all zeros, indicating an anagram
                if(allZeros(charCount)){
                    //add the starting index of the range
                    result.add(left);
                }

                //increase the count of the element character as we move the window
                charCount[s.charAt(left) - 'a']++;
                left++;
            }

            //move the right pointer to expand the window
            right++;
        }

        return result;
    }

    private boolean allZeros(int[] charCount){
        for(int count: charCount){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        _62FindAllAnagramsinaString obj = new _62FindAllAnagramsinaString();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(obj.findAnagrams(s, p));
    }
}

//left = 2
//right = 4
//a = 0
//b = 1
//c = 1
//result = [0, ]
