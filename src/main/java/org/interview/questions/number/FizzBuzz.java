package org.interview.questions.number;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = fizzBuzz(n);
        System.out.println(result);
    }

//    Given an integer n, return a string array answer (1-indexed) where:
//
//    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//    answer[i] == "Fizz" if i is divisible by 3.
//    answer[i] == "Buzz" if i is divisible by 5.
//    answer[i] == i (as a string) if none of the above conditions are true.
//    Example 1:
//
//    Input: n = 3
//    Output: ["1","2","Fizz"]
//    Example 2:
//
//    Input: n = 5
//    Output: ["1","2","Fizz","4","Buzz"]
//    Example 3:
//
//    Input: n = 15
//    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
//    Constraints:
//
//            1 <= n <= 104

    public static List<String> fizzBuzz(int num){
//        Time Complexity: O(n)
//
//        Space Complexity: O(n)
        List<String> response = new ArrayList<>();
        for(int i=1; i<=num; i++){
            if(i%3 == 0 && i%5 == 0){
                response.add("FizzBuzz");
            } else if (i%3 == 0) {
                response.add("Fizz");
            } else if (i % 5 == 0) {
                response.add("Buzz");
            }else {
                response.add(String.valueOf(i));
            }
        }
        return response;
    }
}
