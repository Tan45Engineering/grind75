/*Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false*/
public class _15RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineFreq = new int[26]; //Assuming lowercase English letters only

        //count character frequencies in the magazine
        for(char ch: magazine.toCharArray()){
            magazineFreq[ch - 'a']++;
        }

        //check if it's possible to construct the ransome note
        for(char ch: ransomNote.toCharArray()){
            if(magazineFreq[ch - 'a'] > 0){
                magazineFreq[ch - 'a']--;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        _15RansomNote obj = new _15RansomNote();
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(obj.canConstruct(ransomNote, magazine));
    }
}


// 0 1 0 0 0 0 0 0....
