package org.interview.questions.string;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println("isSubsequence : "+isSubsequence("abac", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t){
        int lBoundary = s.length();
        int rBOundary = t.length();
        int left = 0 ;
        int right = 0;
        while(left < lBoundary && right < rBOundary){
            if(s.charAt(left) == t.charAt(right)){
                left +=1;
            }
            right +=1;
        }
        return left == lBoundary;
    }
}
