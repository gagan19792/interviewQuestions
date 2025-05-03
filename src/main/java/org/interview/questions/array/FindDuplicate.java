package org.interview.questions.array;

import java.util.*;

//Solve the problem [Java]
//Given an array of integers arr that contains n+1 elements between 1 and n inclusive, create a function that returns the duplicate element
//(the element that appears more than once). Assume that:- There is only one duplicate number - The duplicate number can be repeated more than once
//Example 1:
//Input: arr = [4, 2, 1, 3, 1]
//Output: 1
//Example 2:
//Input: arr = [1, 4, 2, 2, 5, 2]
//Output: 2

public class FindDuplicate {

    public static void main(String[] args) {
        List<List<Integer>> levels = new ArrayList<>();
        System.out.println(levels.size());
        int []arr = {1, 4, 2, 2, 5, 2};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicateSol(arr));
    }

    public static int findDuplicate(int[] arr){
        //Time complexity: O(n)
        //Space complexity: O(n)
        HashMap<Integer,Boolean> visited = new HashMap();
        for(int element : arr){
            if(visited.containsKey(element)) return element;
            else visited.put(element, true);
        }
        return 0;
    }

    public static int findDuplicateSol(int nums[]){
        int slow = nums[0];;
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        slow =0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
