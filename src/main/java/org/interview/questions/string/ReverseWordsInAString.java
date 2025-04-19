package org.interview.questions.string;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverse("the sky is      blue   "));
    }

    public static String reverse(String str){
        String[] splitWord = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = splitWord.length-1; i>= 0; i--){
            sb.append(splitWord[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
