package org.interview.questions.array;

import java.util.*;

public class SortColors {

    //Time complexity The time complexity of this solution O(n)
    // since we’re only traversing the array once.
    // Space O(1) no extra space used
    public static int[] sortColors(int[] colors){
        int start = 0;
        int current = 0;
        int end = colors.length-1;

        while(current <= end){
            if(colors[current] == 0){
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            }else{
                int temp = colors[end];
                colors[end] = colors[current];
                colors[current] = temp;
                end--;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

            //System.out.println(Print.repeat("-", 100));
        }
    }
}
