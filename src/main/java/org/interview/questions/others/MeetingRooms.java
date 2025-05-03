package org.interview.questions.others;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static int findSets(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> endTimesHeap = new PriorityQueue<>();
        int sss= intervals[0][1];
        endTimesHeap.offer(sss);

        for (int i = 1; i < intervals.length; i++) {
            int tmp = intervals[i][0];
            if (tmp >= endTimesHeap.peek()) {
                endTimesHeap.poll();
            }
            int ttt = intervals[i][1];
            endTimesHeap.offer(ttt);
        }

        return endTimesHeap.size();
    }

    public static void main(String[] args) {
        int[][][] scheduleMeetings = {
                {{0, 10}, {2, 10}, {11, 30}},
                {{3, 7}, {2, 12}, {10, 20}, {8, 24}},
                {{1, 9}, {5, 8}, {4, 14}, {3, 10}, {11, 25}},
                {{1, 4}, {3, 8}, {8, 11}, {3, 17}, {9, 15}, {16, 18}},
                {{4, 12}, {5, 11}, {4, 9}, {2, 12}, {9, 22}}
        };

        for (int i = 0; i < scheduleMeetings.length; i++) {
            System.out.println((i + 1) + ".\tScheduled meetings: " + Arrays.deepToString(scheduleMeetings[i]));
            System.out.println("\tRooms required: " + findSets(scheduleMeetings[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
