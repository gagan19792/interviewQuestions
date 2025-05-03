package org.interview.questions.others;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        int count = 0;
        int prevEnd = 0;
        for(int[] interval: intervals){
            int end = interval[1];
            if(end > prevEnd){
                count++;
                prevEnd = end;
            }
        }
        return count;
    }
}
