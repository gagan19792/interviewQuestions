package org.interview.questions.others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    // Simple tests
    public static void main(String[] args) {
        int[][] tests = {
                {73,74,75,71,69,72,76,73},
                {30, 40, 50, 60},
                {30, 60, 90},
                {90, 80, 70},
                {}
        };
        for (int[] t : tests) {
            System.out.printf("%s → %s%n",
                    Arrays.toString(t),
                    Arrays.toString(dailyTemperatures(t)));
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int prevDay = stack.pop();
                answer[prevDay] = i-prevDay;
            }
            stack.push(i);
        }
        return answer;
    }
}
