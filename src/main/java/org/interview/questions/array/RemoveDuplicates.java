package org.interview.questions.array;

//Solve the problem [Java]
//Given an array of integers arr, create a function that returns an array containing the values of arr without duplicates
//(the order doesn't matter).
//Example 1:
//Input: arr = [4, 2, 5, 3, 3, 1, 2, 4, 1, 5, 5, 5, 3, 1]
//Output: [4, 2, 5, 3, 1]
//Example 2:
//Input: arr = [1, 1, 1, 1, 1, 1, 1, 1]
//Output: [1]
//Example 3:
//Input: arr = [4, 4, 2, 3, 2, 2, 4, 3]
//Output: [4, 2, 3]

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
        //System.out.println(Arrays.toString(removeDuplicates(arr)));
        System.out.println("Total Unique items in array : "+removeDuplicatesInPlace(new int[] {1,1,2,2,3,4,4}));
    }

    public static int[] removeDuplicates(int[] arr){
        //Time complexity: O(n)
        //Space complexity: O(n)
        Set<Integer> values = new HashSet<>();
        for(int i=0; i< arr.length;i++){
            values.add(arr[i]);
        }
        int[] noDuplicatesArr = new int[values.size()];
        int i=0;
        for(Integer in: values){
            noDuplicatesArr[i++] = in;
        }
        return noDuplicatesArr;
    }

    public static int removeDuplicatesInPlace(int[] nums){
        if(nums.length == 0) return 0;

        int i=0;
        for(int j=1; j< nums.length; j++){
            if(nums[j] != nums[i])
                i++;

            nums[i] = nums[j];
        }

        return i+1;
    }


}
