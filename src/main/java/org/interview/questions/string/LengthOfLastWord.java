package org.interview.questions.string;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s){
        int end = s.length()-1;
        while(end >=0 && s.charAt(end) == ' '){
            end --;
        }
        int start = end;
        while(start >=0 && s.charAt(start) != ' '){
            start --;
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("Last word Length : "+lengthOfLastWord("Hello World from e"));
    }
}
