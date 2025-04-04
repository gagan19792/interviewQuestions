package org.interview.questions.math;

public class MaxSubArray {

    public static int maxSubArray(int nums[]){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length;i++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }


        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum is: " + solution.maxSubArray(nums)); // Expected output: 6
    }
}
