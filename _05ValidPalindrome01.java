/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.



        Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.*/
public class _05ValidPalindrome01 {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s2 = new StringBuffer(s1).reverse().toString();
        return s1.equals(s2);
    }

    public static void main(String args[]){
        _05ValidPalindrome01 obj = new _05ValidPalindrome01();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }
}
