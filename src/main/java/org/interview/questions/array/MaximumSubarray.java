package org.interview.questions.array;

//Solve the problem [Java]
//Given a non-empty array of integers arr, create a function that returns the sum of the subarray that has the greatest sum.
//We don't consider the empty array [] as a subarray.
//Example 1:
//Input: arr = [2, 3, -6, 4, 2, -8, 3]
//Output: 6
//Explanation: the maximum subarray is [4, 2], its sum is 6
//Example 2:
//Input: arr = [2, 3, -1, 4, -10, 2, 5]
//Output: 8
//Explanation: the maximum subarray is [2, 3, -1, 4], its sum is 8
//Example 3:
//Input: arr = [-3, -1, -2]
//Output: -1
//Explanation: the maximum subarray is [-1], its sum is -1

public class MaximumSubarray {

    // Brute force solution:
    // Time complexity: O(n³)
    // Space complexity: O(1)
    static int maximumSubarrayBF(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                int actualSum = 0;
                for(int k = i; k <= j; k++) actualSum += arr[k];
                maxSum = Math.max(maxSum, actualSum);
            }
        }
        return maxSum;
    }

    // By using Kadane's algorithm:
    // Time complexity: O(n)
    // Space complexity: O(1)
    static int maximumSubarray(int[] arr){
        int globalSum = Integer.MIN_VALUE;
        int localSum = 0;
        for(int element : arr){;
            localSum = Math.max(element, localSum + element);
            globalSum = Math.max(globalSum, localSum);
        }
        return globalSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -6, 4, 2, -8, 3};
        System.out.println(maximumSubarrayBF(arr));
    }
}

