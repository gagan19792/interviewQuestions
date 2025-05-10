package org.interview.questions.array;

public class RemoveDuplicate1 {

    public static int Duplicate(int[] nums){
        int n = nums.length;
        if(n == 0)return 0;
        int inserIndex = 1;
        for(int i=1; i< n ; i++){
            if(nums[i] != nums[i-1]){
                nums[inserIndex] = nums[i];
                inserIndex++;
            }
        }
        return inserIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2};
        System.out.println(Duplicate(nums));
    }
}
