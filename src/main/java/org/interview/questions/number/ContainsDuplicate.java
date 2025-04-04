package org.interview.questions.number;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] values){
        int left = 0;
        int right = values.length-1;
        while(left<right){
            if (values[left] == values[right]){
                return true;
            }
            left++;
            right--;
        }
        return false;
    }

    public static boolean solutionSet(int[] val){
        Set<Integer> unique = new HashSet<>();
        for(int v : val){
            if(!unique.add(v)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solutionSet(new int[] {1,2,3,1}));
    }

}
