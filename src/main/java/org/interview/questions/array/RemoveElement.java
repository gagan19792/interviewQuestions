package org.interview.questions.array;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int reader = 0; int writer = 0;
        int n = nums.length;
        while(reader < n){
            if(nums[reader] == val){
                reader++;
            }else{
                nums[writer] = nums[reader];
                reader++;
                writer++;
            }
        }
        return writer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
