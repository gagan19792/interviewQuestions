package org.interview.questions.array;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int nums[]){

        int left = 0;;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left) / 2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum in nums1: " + solution.findMin(nums1)); // Expected output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum in nums2: " + solution.findMin(nums2)); // Expected output: 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Minimum in nums3: " + solution.findMin(nums3)); // Expected output: 11
    }
}
