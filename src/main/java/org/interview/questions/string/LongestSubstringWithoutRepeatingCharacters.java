package org.interview.questions.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] arg) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = LongestSubstringWithoutRepeatingCharacters.findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int findLongestSubstring(String str) {
        if(str == null || str.length() ==0){
            return 0;
        }

        int i = 0;
        HashMap<Character, Integer> values = new HashMap<>();
        int windowStart=0; int windowLength = 0; int longest =0;
        for(; i< str.length(); i++){
            if(!values.containsKey(str.charAt(i))){
                values.put(str.charAt(i), i);
            }else {
                if(values.get(str.charAt(i)) >= windowStart){
                    windowLength = i - windowStart;
                    if(longest < windowLength){
                        longest = windowLength;
                    }
                    windowStart = values.get(str.charAt(i))+1;
                }
                values.replace(str.charAt(i), i);
            }
        }
        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
    }
}
