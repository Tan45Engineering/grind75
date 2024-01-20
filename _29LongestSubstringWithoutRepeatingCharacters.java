import java.util.HashSet;

/*Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.*/
public class _29LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        HashSet<Character> set = new HashSet<>();

        //sliding window technique (left and right pointers)
        while(right < n){
            //if the character at 'right' is not in the set, add it and expand the window
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right-left + 1);
                right++;
            }else{
                //if the character at 'right' is in the set, remove the character at 'left' and shrink the window
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String args[]){
        _29LongestSubstringWithoutRepeatingCharacters obj = new _29LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}

//abcb
//set = c b
//maxLength
//set
//left and right
