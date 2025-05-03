package org.interview.questions.others;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int nums[] = new int[] {0,1,0,3,12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeros(int[] nums){
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
