package org.interview.questions.array;

import java.util.*;

public class IntersectionOfTwoArraysII {


    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectWithHashMap(nums1, nums2))); // Output: [4, 9] or [9, 4]
        System.out.println(Arrays.toString(intersectInPlace(nums1, nums2))); // Output: [4, 9] or [9, 4]
    }
    public static int[] intersectWithHashMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> coutMap = new HashMap<>();
        for(int num :nums1){
            coutMap.put(num, coutMap.getOrDefault(num, 0)+1);
        }

        List<Integer> result = new ArrayList<>();
        for(int num: nums2){
            if(coutMap.containsKey(num) && coutMap.get(num) > 0){
                result.add(num);
                coutMap.put(num,coutMap.get(num)-1);
            }
        }

        //convert list to array;
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    public static int[] intersectInPlace(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0,k);
    }
}
