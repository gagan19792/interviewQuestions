package org.interview.questions.sorting;

public enum SortingUtil {
INSTANCE;

public static void  swapElements(int[] array, int i, int j){
    int tmp = array[j];
    array[j] = array[i];
    array[i] = tmp;
}

public static void print(int[] array){
    for(int i: array){
        System.out.print(i+", ");
    }
    System.out.println("");
}
}
