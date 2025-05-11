package org.interview.questions.array;

import java.util.Arrays;

public class MoveZeroes {

    public static int[] moveZeroes(int[] nums) {
        int left =0;
        for(int right= 0 ;right < nums.length; right++){
            if(nums[right] == 0){
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[] {0,1,0,3,12})));
    }
}
