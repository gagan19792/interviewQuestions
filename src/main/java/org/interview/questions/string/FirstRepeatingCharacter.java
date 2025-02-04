package org.interview.questions.string;

import java.util.HashSet;
import java.util.Set;

//Solve the problem [Java]
//Given a string str, create a function that returns the first repeating character.
//If such character doesn't exist, return the null character '\0'.
//Example 1:
//Input: str = "inside code"
//Output: 'i'
//Example 2:
//Input: str = "programming"
//Output: 'r'
//Example 3:
//Input: str = "abcd"
//Output: '\0'
//Example 4:
//Input: str = "abba"
//Output: 'b'

public class FirstRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstRepeatingCharacter("abba"));
    }

    public static char firstRepeatingCharacter(String str){
        //Time complexity: O(n)
        //Space complexity: O(n)
        Set<Character> uniqueStr = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            if (uniqueStr.add(str.charAt(i)) == false){
                return str.charAt(i);
            }
        }
        return '\0';
    }
}
