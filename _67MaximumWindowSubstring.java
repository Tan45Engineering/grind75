/*Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/
public class _67MaximumWindowSubstring {
    public String minWindow(String s, String t) {
        //array to represent the frequency of characters in the current window
        int[] charCountWindow = new int[128];

        //initialize the frequency array with characters from string t
        for(char c: t.toCharArray()){
            charCountWindow[c]++;
        }

        //variables to track window boundaries and character freq
        int left = 0;
        int right = 0;
        int requiredChars = t.length();
        int formedChars = 0;

        //variables to trach the minimum window
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        //start the traversal
        while(right < s.length()){
            //expand the window to the right
            char cRight = s.charAt(right);
            charCountWindow[cRight]--;

            //check if the current character contributes to the required characters
            if(charCountWindow[cRight] >= 0){
                formedChars++;
            }

            //contract the window from the left
            while(formedChars == requiredChars){
                //updat the minimum window if smaller
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    minLeft = left;
                    minRight = right + 1;
                }

                //contract the window from the left
                char cLeft = s.charAt(left);
                charCountWindow[cLeft]++;

                //check if the current character no longer contributes to the required characters
                if(charCountWindow[cLeft] > 0){
                    formedChars--;
                }

                //move the left pointer
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }

    public static void main(String args[]){
        _67MaximumWindowSubstring obj = new _67MaximumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }
}
