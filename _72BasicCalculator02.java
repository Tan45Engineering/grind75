/*Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "1 + 1"*/
public class _72BasicCalculator02 {
    int index; //traverse the string in one pass
    public int calculate(String s) {
        index = 0;
        return calculateHelper(s);
    }

    //function to be called recursively
    private int calculateHelper(String s){
        int result = 0;
        int currentNumber = 0;
        int sign = 1;

        while(index < s.length()){
            char currentChar = s.charAt(index++);
            if(currentChar >= '0' && currentChar <= '9'){
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }else if(currentChar == '('){
                currentNumber = calculateHelper(s); //to solve internal result
            }else if(currentChar == ')'){
                return result + sign*currentNumber;
            }else if(currentChar == '+' || currentChar == '-'){
                result += sign*currentNumber;
                currentNumber = 0;
                sign = (currentChar == '+') ? 1 : -1;
            }
        }

        return result + (sign*currentNumber); //last number is left to be processed
    }

    public static void main(String args[]){
        _72BasicCalculator01 obj = new _72BasicCalculator01();
        String s = "1+1";
        System.out.println(obj.calculate(s));
    }
}
