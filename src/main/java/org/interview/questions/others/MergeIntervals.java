package org.interview.questions.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {


        // Test cases
        int[][][] testInputs = {
                {{1,3},{2,6},{8,10},{15,18}},
                {{1,4},{4,5}},
                {{1,4},{2,3}},
                {{5,7},{1,3},{2,6},{8,10}}
        };

        for (int i = 0; i < testInputs.length; i++) {
            int[][] input = testInputs[i];
            System.out.println("Test case " + (i+1) + ": " + Arrays.deepToString(input));
            int[][] result = merge(input);
            System.out.println("Merged:      " + Arrays.deepToString(result));
            System.out.println("------------------------------------");
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // 1. Sort by start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Prepare list to hold merged intervals
        List<int[]> merged = new ArrayList<>();
        // Start with the first interval
        int[] current = intervals[0];
        merged.add(current);

        // 3. Iterate and merge as needed
        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart  = interval[0];
            int nextEnd    = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap: extend the end if needed
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: move to next interval
                current = interval;
                merged.add(current);
            }
        }

        // 4. Convert list back to array
        return merged.toArray(new int[merged.size()][]);
    }


}
