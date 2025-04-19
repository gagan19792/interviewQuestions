package org.interview.questions.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
    //O(n) time and O(n) space (for the char array):
    public static String reverseVowels(String s) {
        if (s == null || s.length() < 2){
            return s;
        }

        Set<Character> vowels = new HashSet<>();
        for(char c : "aeiouAEIOU".toCharArray()){
            vowels.add(c);
        }
        char[] c = s.toCharArray();
        int i=0;
        int j= c.length-1;
        while(i<j){
            while( i < j && !vowels.contains(c[i])){
                i++;
            }
            while(i < j && !vowels.contains(c[j])){
                j--;
            }
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j++;
        }

        return new String(c);
    }
}
