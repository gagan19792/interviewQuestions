package org.interview.questions.array;

public class CanJump {

    public static boolean canJump(int[] nums){
        int reachable = 0;;
        for(int i=0; i< nums.length; i++){
            if(i>reachable){
                return false;
            }
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
