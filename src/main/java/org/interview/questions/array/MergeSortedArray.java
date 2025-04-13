package org.interview.questions.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArray {

    public static void mergeSortedArray(int nums1[], int m, int nums2[], int n){
        int p1 = m-1;
        int p2 = n-1;
        for(int i=m+n-1; i>=0; i--){
            if(p1 >=0 && p2 >=0){
                nums1[i] = nums1[p1] > nums2[p2]?nums1[p1--]: nums2[p2--];
            }else if(p1 >=0){
                nums1[i] = nums1[p1--];
            }else nums1[i] = nums2[p2--];
        }
        return;
    }

    public static void main(String[] args) {
        int nums1[] = new int[] {1,2,3,0,0,0};
        int nums2[] = new int[] {2,5,6};
        System.out.println("nums1"+ Arrays.toString(nums1));
        mergeSortedArray(nums1, 3, nums2, 3);
        System.out.println("nums1"+ Arrays.toString(nums1));
    }
}
