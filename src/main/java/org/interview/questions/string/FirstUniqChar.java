package org.interview.questions.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println("FirstUniqChar position : "+firstUniqChar("GGa"));
    }
    public  static int firstUniqChar(String s) {
        Map<Character, Integer> values = new HashMap<>();
        for(char ch : s.toCharArray()){
            values.put(ch, values.getOrDefault(ch, 0)+1);
        }
        for(int i=0; i<= s.length()-1; i++){
            if(values.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}
