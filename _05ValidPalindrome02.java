/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.



        Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.*/
public class _05ValidPalindrome02 {
    public boolean isPalindrome(String s) {
        int left = 0; //pointer for the start of the string
        int right = s.length() - 1; //pointer for the end of the string

        while(left < right){
            //get the character at the left pointer and convert to lowercase
            char leftChar = Character.toLowerCase(s.charAt(left));

            //get the character at the right pointer and convert to lowercase
            char rightChar = Character.toLowerCase(s.charAt(right));

            if(!Character.isLetterOrDigit(leftChar)){
                left++; //if the left character is not a alphanumeric, move the left pointer to the right;

            }else if(!Character.isLetterOrDigit(rightChar)){
                right--; //if the right character is not a alphanumeric, move the right pointer to the left;

            } else if(leftChar != rightChar){
                return false; //if the alphanumeric characters at left and right pointers are not equal, it's not a palindrome
            }else{
                left++;//Move the left pointer towards right
                right--;//Move the right pointer towards left
            }
        }

        return true;
    }

    public static void main(String args[]){
        _05ValidPalindrome01 obj = new _05ValidPalindrome01();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }
}
