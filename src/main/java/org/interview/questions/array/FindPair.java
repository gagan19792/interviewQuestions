package org.interview.questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers arr and an integer k, create a boolean function that checks if there exist two elements in arr
// such that we get k when we add them together.
//Example 1:
//Input: arr = [4, 5, 1, -3, 6], k = 11
//Output: true
//Explanation: 5 + 6 is equal to 11
//Example 2:
//Input: arr = [4, 5, 1, -3, 6], k = -2
//Output: true
//Explanation: 1 + (-3) is equal to -2
//Example 3:
//Input: arr = [4, 5, 1, -3, 6], k = 8
//Output: false
//Explanation: there is no pair that sums up to 8

public class FindPair {

    public static void main(String[] args) {
        int[] arr = {4,5,1, -3,6};
        int k = -2;
        System.out.println("pair found : "+ hashTable(arr, k));
    }

    public static boolean bruteForce(int[] arr, int k){
        //Time complexity: O(n²)
        //Space complexity: O(1)
        for(int i=0; i< arr.length;i++){
            //System.out.println(arr[i]);
            for(int j=i+1; j< arr.length;j++){
                if (arr[i]+arr[j] == k){
                    System.out.println(arr[i]+" + "+arr[j]+" = "+k);
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean twoPointer(int[] arr, int k){
        //Time complexity: O(nlogn) Sorting the array costs nlogn
        //Space complexity: Depends on the sorting algorithm we use
        int l = 0;
        int r = arr.length-1;
        Arrays.sort(arr);
        while(l < r){
            if(arr[l]+arr[r] == k)
                return true;
            else if (arr[l]+arr[r] > k) {
                r--;
            }else{
                l++;
            }
        }
        return false;
    }

    public static boolean hashTable(int[] arr, int k){
        //Time complexity: O(n)
        //Space complexity: O(n)
        Map<Integer, Integer> values = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            int numToFind = k - arr[i];
            if(values.get(numToFind) != null){
                return true;
            } else {
                values.put(arr[i], i);
            }
        }

        return false;
    }


}
