package org.interview.questions.others;

import java.util.Arrays;

public class NonOverlappingIntervals {

    // Simple tests
    public static void main(String[] args) {
        int[][][] tests = {
                { {1,2}, {2,3}, {3,4}, {1,3} },  // → 1
                { {1,2}, {1,2}, {1,2} },         // → 2
                { {1,2}, {2,3} },               // → 0
                { {1,100}, {11,22}, {1,11}, {2,12} }, // → 2
                { }                              // → 0
        };

        for (int[][] intervals : tests) {
            System.out.printf("%s → %d%n",
                    Arrays.deepToString(intervals),
                    eraseOverlapIntervals(intervals));
        }
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort intervals by end time ascending
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        // end time of the last interval we kept
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end   = intervals[i][1];

            if (start < prevEnd) {
                // Overlaps: remove the current interval
                removals++;
            } else {
                // No overlap: keep it and update prevEnd
                prevEnd = end;
            }
        }

        return removals;
    }
}
