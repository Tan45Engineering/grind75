import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]*/
public class _60LetterCombinationsofaPhoneNumber {
    //a map to store the mapping of each digit to its corresponding letters
    private static final Map<Character, String> digitToLetters = new HashMap<>();

    //static initialization block to populate the map
    static{
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        //result list
        List<String> result = new ArrayList<>();

        //base case
        if(digits == null || digits.length() == 0){
            return result;
        }

        //StringBuilder to build the current combination during backtracking
        StringBuilder currentCombination = new StringBuilder(); //"ae"

        backtrack(currentCombination, digits, 0, result);

        return result;
    }

    //recursive backtracking method to generate letter combinations
    private void backtrack(StringBuilder currentCombination, String digits, int index, List<String> result){
        //base case: if we have processed all digits, add the current combination to the result list
        if(index == digits.length()){
            result.add(currentCombination.toString());
            return;
        }

        //get the current digit and its corresponding letters
        char currentDigit = digits.charAt(index); //2, 3
        String letters = digitToLetters.get(currentDigit); //abc, def

        //iterate through each letter and explore different combinations
        for(char letter: letters.toCharArray()){
            //choose the current letter
            currentCombination.append(letter);

            //explore further with the next digit
            backtrack(currentCombination, digits, index + 1, result);

            //backtrack: remove the last letter to explore other possibilities
            currentCombination.deleteCharAt(currentCombination.length() - 1);

        }
    }

    public static void main(String args[]){
        _60LetterCombinationsofaPhoneNumber obj = new _60LetterCombinationsofaPhoneNumber();
        String digits = "23";
        System.out.println(obj.letterCombinations(digits));
    }
}
