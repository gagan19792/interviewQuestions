package org.interview.questions.array;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][][] tests = {
                { {10,16}, {2,8},  {1,6}, {7,12} },  // → 2 ([2,8] arrow at x=8 bursts [2,8] and [1,6]; [7,12] arrow at x=12)
                { {1,2},   {3,4},  {5,6}, {7,8} },   // → 4 (no overlaps)
                { {1,2},   {2,3},  {3,4}, {4,5} },   // → 2 (arrow at x=2 and x=4)
                { {1,10},  {2,3},  {4,5}, {6,7}, {8,9} }, // → 1 (all nested in [1,10])
                { }                                  // → 0
        };

        for (int[][] balloons : tests) {
            System.out.printf("%s → %d%n",
                    Arrays.deepToString(balloons),
                    findMinArrowShots(balloons));
        }
    }

    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length ==0) return 0;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        int arrows = 1;
        int currentArrowpos = points[0][1];

        for(int i=1; i< points.length; i++){
            if(points[i][0] > currentArrowpos){
                arrows++;
                currentArrowpos = points[i][1];
            }
        }
        return arrows;
    }
}
