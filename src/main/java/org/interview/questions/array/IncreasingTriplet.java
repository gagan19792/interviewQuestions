package org.interview.questions.array;

public class IncreasingTriplet {

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4, 5},     // true: 1<2<3
                {5, 4, 3, 2, 1},     // false
                {2, 1, 5, 0, 4, 6},  // true: 1<4<6
                {20, 100, 10, 12, 5, 13}, // true: 10<12<13
                {1, 1, 1, 1},        // false (no strictly increasing)
                {1, 5, 0, 4, 1, 3}   // true: 0<4<? Actually 0<4<... but better is 1<4<...3? No—but 0<1<3 via indices [2,4,5]
        };

        for (int[] test : tests) {
            System.out.printf("%s → %b%n",
                    java.util.Arrays.toString(test),
                    increasingTriplet(test));
        }
    }

    //O(n)-time, O(1)-space Java solution
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i: nums){
            if(i <= first){
                first = i;
            }else if (i <= second){
                second = i;
            }else{
                return true;
            }
        }

        return false;
    }
}
