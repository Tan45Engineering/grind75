import java.util.HashMap;
import java.util.Map;


/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true*/
public class _07ValidAnagram01 {
    public boolean isAnagram(String s, String t) {
        //if length of two string is not equaly, return false
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        //store characters of first string into the map with frequencies
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //traverse the second string
        for(int i = 0; i < t.length(); i++){
            //if the character is already available in the map
            if(map.containsKey(t.charAt(i))){
                if(map.getOrDefault(t.charAt(i), 0) == 0){
                    return false;
                }
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }else{
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
