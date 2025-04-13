package org.interview.questions.sorting;

import java.util.Arrays;

//Time complexity: O(n²)
//Space complexity: O(1)
public class BubbleSort {

    public static int[]  bubbleSort(int[] array){
        int n = array.length-1;
        for(int i=n; i>0;i--){
            for(int j=0; j <i; j++){
                if(array[j] >array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,3,2,6,7,4};
        System.out.println("Bubble Sort : "+ Arrays.toString(bubbleSort(array)));
    }
}
