package org.interview.questions.sorting;

import java.util.Arrays;

//Time complexity: O(n²)
//Space complexity: O(1)
public class BubbleSort {

    public static int[]  bubbleSort(int[] array){
        for(int i=0 ; i< array.length;i++){
            boolean swapped = false;
            for(int j= array.length-1; j>i;j--){
                if(array[j] < array[j-1]){
                    SortingUtil.swapElements(array, j, j-1);
                    swapped = true;
                }
            }
            SortingUtil.print(array);
            if(!swapped){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,3,2,6,7,4};
        bubbleSort(array);
    }
}
