import java.util.HashSet;
import java.util.Set;

/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.*/
public class _17LongestPalindrome01 {
    public int longestPalindrome(String s) {
        int length = 0; //initialize the length of the longest palindrome
        Set<Character> set = new HashSet<>();//set to store characters that have been encountered

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(set.contains(currentChar)){
                //if the character is already in the set, it means we can use it to form a palindrome
                //so, we increase the lenght by 2 and remove this character from the set to avoid duplication
                length += 2;
                set.remove(currentChar);

            }else{
                //if the character is not in the set, add it to the set for future potential use
                set.add(currentChar);
            }
        }

        if(set.size() > 0){
            //if there are characters left in the set, we can use one of the characters as the center of the palindrome
            //this will add 1 to the length
            return length + 1;
        }

        return length;
    }

    public static void main(String args[]){
        _17LongestPalindrome01 obj = new _17LongestPalindrome01();
        String s = "abccccdd";
        System.out.println(obj.longestPalindrome(s));
    }
}

// abccccdd
// Set: ab
// length = 0, 2, 4, 6, 7
