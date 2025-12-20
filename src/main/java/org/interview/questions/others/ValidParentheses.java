package org.interview.questions.others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("is Parentheses valid ? "+isValid("()"));
        System.out.println("is Parentheses valid ? "+isValid("("));
        System.out.println("is Parentheses valid ? "+isValid("A{(B)C}"));
    }

    public static Map<Character, Character> PAIRS = Map.of('}','{',')','(',']','[');

//    Time: O(n)
//    Space: O(1)
    public static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(PAIRS.containsKey(c)){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top != PAIRS.get(c)) return false;
            } else if (c == '{' || c =='[' || c =='(') {
                stack.push(c);
            } else {

            }
        }
        return stack.isEmpty();
    }
}
