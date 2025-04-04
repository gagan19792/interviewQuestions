package org.interview.questions.leetcode.easy;

import java.util.HashMap;

public class TwoSum {

//    Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.
//            Example 1:
//
//    Input: numbers = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because numbers[0] + numbers[1] == 9, we return [0, 1].
//    Example 2:
//
//    Input: numbers = [3,2,4], target = 6
//    Output: [1,2]
//    Example 3:
//
//    Input: numbers = [3,3], target = 6
//    Output: [0,1]
// This solution runs in O(n) time complexity, as we only pass through the array once, and it uses O(n) space for the hash map.
    public int[] twoSum(int nums[], int target){
        //Create a HashMap to store the difference and its corresponding index
        HashMap<Integer, Integer> values = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            //calculate the complement of current number
            int complement = target - nums[i];

            //check if compliment exist in map
            if(values.containsKey(complement)){
                //If found return the indices
                return new int[] {values.get(complement), i};
            }
            //otherwise, store the current number and it's index in the map
            values.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int nums[] = {2,7,11,15};
        int target = 13;
        int result[] = ts.twoSum(nums, target);
        System.out.println("Indices : "+result[0]+", "+result[1]);
    }
}
