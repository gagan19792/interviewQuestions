package org.interview.questions.string;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        char[] response = new char[c1.length+c2.length];
        int i=0;
        int j=0;
        int l1 = c1.length;
        int l2 = c2.length;
        while(i < l1 || i <l2){
            if(i < l1){
                response[j++] = c1[i];
            }
            if(i < l2){
                response[j++] = c2[i];
            }
            i++;
        }

        return new String(response) ;
    }

    public static void main(String[] args) {
        //System.out.println(mergeAlternately("abc","pqr"));
        //System.out.println(mergeAlternately("abcd","pq"));
        System.out.println(mergeAlternately("ab","pqrs"));
    }
}
