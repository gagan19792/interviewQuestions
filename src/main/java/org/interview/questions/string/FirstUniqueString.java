package org.interview.questions.string;

import java.util.HashMap;

public class FirstUniqueString {

    public static void main(String[] args) {
        System.out.println(firstUniqueString("lloveo"));
    }

//    Time O(N)
//    Space O(1)
    public static int firstUniqueString(String s){
        int length = s.length();
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i< s.length(); i++){
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqueString2(String s){
        for(int i = 0; i< s.length(); i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
