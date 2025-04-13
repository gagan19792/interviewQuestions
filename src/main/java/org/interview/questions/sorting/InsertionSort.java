package org.interview.questions.sorting;

import java.util.Arrays;

public class InsertionSort {

    // Method to perform insertion sort on an array.
    public static int[] insertionSort(int[] arr) {
        // Start from the second element (index 1) because the first element is trivially sorted.
        for (int i = 1; i < arr.length; i++) {
            // Store the value of the current element as key.
            int key = arr[i];
            int j = i - 1;

            // Shift elements of the sorted segment forward if they are greater than key.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key into its correct position.
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,5,3,2,6,7,4};
        System.out.println("Bubble Sort : "+ Arrays.toString(insertionSort(array)));
    }
}
