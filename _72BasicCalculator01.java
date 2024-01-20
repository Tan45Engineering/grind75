import java.util.Stack;

/*Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "1 + 1"*/
public class _72BasicCalculator01 {
    public int calculate(String s) {
        int result = 0;
        int sign = 1; //positive sign
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);

            if(Character.isDigit(currentChar)){
                //construct the current number
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }else if(currentChar == '+' || currentChar == '-'){
                //add the current number to the result with the current sign
                result += sign*currentNumber;

                //reset currenNumber
                currentNumber = 0;
                sign = (currentChar == '+') ? 1: -1;
            }else if(currentChar == '('){
                //push the current result and sign to the stack
                stack.push(result);
                stack.push(sign);

                //reset result and sign
                result = 0;
                sign = 1;
            }else if(currentChar == ')'){
                //add the currentNumber to the result with the current sign
                result += sign * currentNumber;
                //reset currentNumber
                currentNumber = 0;

                //pop the sign and previous result from the stack
                result *= stack.pop(); //previous sign
                result += stack.pop(); //previous result
            }
        }

        //add the last number to the result with the sign
        result += sign*currentNumber;

        return result;
    }

    public static void main(String args[]){
        _72BasicCalculator01 obj = new _72BasicCalculator01();
        String s = "1+1";
        System.out.println(obj.calculate(s));
    }
}
