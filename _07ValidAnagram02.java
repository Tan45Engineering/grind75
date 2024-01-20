
/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true*/
public class _07ValidAnagram02 {
    public boolean isAnagram(String s, String t) {
        //if length of two string is not equaly, return false
        if(s.length() != t.length()){
            return false;
        }

        int[] charCount = new int[26];

        //count character frequencies in string s
        for(char ch: s.toCharArray()){
            charCount[ch - 'a']++; //increase by 1
        }

        //decrement character frequencies for string t
        for( char ch: t.toCharArray()){
            charCount[ch - 'a']--; //decrease by 1
        }

        for(int count : charCount){
            if(count != 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        _07ValidAnagram01 obj = new _07ValidAnagram01();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(obj.isAnagram(s, t));
    }
}
