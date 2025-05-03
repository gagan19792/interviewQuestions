package org.interview.questions.string;

public class Anagram {

    public static void main(String[] args) {

        System.out.println(anagram("gagan" , "nagag"));
        System.out.println(anagram("gagan" , "nagagq"));
    }

//    Time : O(N+K)
//    Space : O(K)
    public static boolean anagram(String s, String t){
        if(s.length() != t.length())
            return false;

        int[] sCounter = new int[26];
        int[] tCounter = new int[26];

        for(int i=0; i< s.length() ; i++){
            sCounter[s.charAt(i) - 'a']++;
            tCounter[t.charAt(i) - 'a']++;
        }
        for(int i=0; i< 26; i++){
            if(sCounter[i] != tCounter[i])
                return false;
        }
        return true;
    }
}
