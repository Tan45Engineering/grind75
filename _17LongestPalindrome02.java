/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.*/
public class _17LongestPalindrome02 {
    public int longestPalindrome(String s) {
        int length = 0;
        int[] charCount = new int[128]; //Assuming ASCII characters, can be extended to Unicode

        for(char c: s.toCharArray()){
            charCount[c]++;
        }

        for(int count: charCount){
            //for each character, we can use an even number of them to form a palindrome
            //so, we add (count/2) * 2 to the lenght
            length += (count/2) * 2;
        }

        //if there's any character left with an odd count, we can use one of them as the center
        if(length < s.length()){
            length++;
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
// 4, 6
