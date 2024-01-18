import java.util.Stack;


/*
* Problem Statement:
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true*/
class _02ValidParenthesis {
    public boolean isValid(String s) {
        //create a stack to store open brackets
        Stack<Character> stack = new Stack<>();

        //check the first character
        char temp = s.charAt(0);
        if(temp == ')' || temp == '}' || temp == ']'){
            //if it starts with a closing bracket, it is invalid
            return false;
        }

        //loop through each character in the string
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c =='['){
                stack.push(c);
            }
            else{
                if(stack.size() == 0){
                    //if stack is empty, there's nothing to match with
                    return false;
                }
                if(c == ')'){
                    char ch = stack.peek();
                    if(ch == '{' || ch == '['){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else if(c == '}'){
                    char ch = stack.peek();
                    if(ch == '(' || ch == '['){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else if(c == ']'){
                    char ch = stack.peek();
                    if(ch == '(' || ch == '{'){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }

        }

        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        _02ValidParenthesis obj = new _02ValidParenthesis();
        String s = "()[]{}";
        Boolean ans = obj.isValid(s);
        System.out.println(ans);
    }
}

// ({}): -> 

//()}: -> 

// }, ), ](){}