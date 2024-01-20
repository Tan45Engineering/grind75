/*Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.*/
public class _56LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        //base case
        if(s == null || s.length() == 0){
            return "";
        }

        int start = 0; //Start index of longest palindrome
        int end = 0; //End index of longest palindrome

        for(int i = 0 ; i < s.length(); i++){
            //for odd length palindrome
            int len1 = expandAroundCenter(s, i, i);//3

            //for even length palindrome
            int len2 = expandAroundCenter(s, i, i+1);//0

            int maxLength = Math.max(len1, len2);//3

            //update the indices if a longer palindrome is found
            if(maxLength > end - start){
                start = i - (maxLength - 1)/2;//0
                end = i + maxLength/2;//2
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        //expand around the center and count the length of the palindrome
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        //return the length of the palindrome
        return right - left - 1;
    }

    public static void main(String args[]){
        _56LongestPalindromeSubstring obj = new _56LongestPalindromeSubstring();
        String s = "babad";
        System.out.println(obj.longestPalindrome(s));
    }
}

//babad
//start = 0
//end = 0
//left = -1
//right = 3
