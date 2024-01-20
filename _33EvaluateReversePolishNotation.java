import java.util.Stack;

/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9*/
public class _33EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        //create a stack to keep track of operands
        Stack<Integer> stack = new Stack<>();

        //iterate through the tokens
        for(String token: tokens){
            if(isOperator(token)){
                //if the token is an operator, pop two operands from the stack and perform the operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                //push the result back to the stack
                stack.push(result);
            }else{
                //if the token is an operand, convert it to integer and push to stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    //helper method to check if the token is an operator
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    //helper method to perform operation based on the operator
    private int performOperation(int operand1, int operand2, String operator){
        switch(operator){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String args[]){
        _33EvaluateReversePolishNotation obj = new _33EvaluateReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(obj.evalRPN(tokens));
    }
}

// tokens: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

// ans= ((10*(6/((9+3) * -11))) + 17) + 5

// stack:
