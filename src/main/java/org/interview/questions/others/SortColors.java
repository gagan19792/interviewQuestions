package org.interview.questions.others;

public class SortColors {

    public static int[] sortColors (int[] colors) {

        int start = 0;
        int current = 0;
        int end = colors.length-1;

        while(current <=end){
            if(colors[current] == 0){
                int tmp = colors[current];
                colors[current] = colors[start];
                colors[start] = tmp;
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else{
                int tmp = colors[current];
                colors[current] = colors[end];
                colors[current] = tmp;
                end--;
            }
        }
        return colors;
    }
}
