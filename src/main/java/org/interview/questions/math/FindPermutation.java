package org.interview.questions.math;

import java.util.Arrays;
import java.util.Stack;

public class FindPermutation {

    public static int[]  findPermutation(String s){
        int n = s.length();
        int index = 0;
        int res[] = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<=n; i++){
            stack.push(i+1);
            if(i==n || s.charAt(i) == 'I'){
                while(!stack.isEmpty()){
                    res[index++] = stack.pop();
                }
            }
        }
        return res;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Example 1:
        String s1 = "IDID";
        int[] permutation1 = findPermutation(s1);
        System.out.println("Permutation for signature \"IDID\": " + Arrays.toString(permutation1));
        // Example 2:
        String s2 = "III";
        int[] permutation2 = findPermutation(s2);
        System.out.println("Permutation for signature \"III\": " + Arrays.toString(permutation2));
        // Example 3:
        String s3 = "DDI";
        int[] permutation3 = findPermutation(s3);
        System.out.println("Permutation for signature \"DDI\": " + Arrays.toString(permutation3));
    }
}
