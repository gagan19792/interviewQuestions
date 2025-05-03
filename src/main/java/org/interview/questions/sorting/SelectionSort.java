package org.interview.questions.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SelectionSort {

    public static void selectionSort(int[] array){
        //Time Complexity : O(N2), Space : O(1)
        for(int i=0; i< array.length;i++){
            for(int j = i+1; j<array.length;j++){
                if(array[i] > array[j]){
                    SortingUtil.swapElements(array, i , j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,3,2,6,7,4};
        selectionSort(array);
        SortingUtil.print(array);
    }
}
