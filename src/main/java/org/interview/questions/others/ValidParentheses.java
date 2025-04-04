package org.interview.questions.others;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses("(asdasdasd{})"));
    }
    public static boolean validParentheses(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
