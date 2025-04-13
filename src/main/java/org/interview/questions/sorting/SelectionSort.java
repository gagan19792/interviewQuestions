package org.interview.questions.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SelectionSort {

    public static int[] selectionSort(int[] array){
        for(int i=0; i<array.length;i++){
            int minIndex =i;
            for(int j=0; j<array.length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,3,2,6,7,4};
        System.out.println("Selection Sort : "+ Arrays.toString(selectionSort(array)));
    }
}
