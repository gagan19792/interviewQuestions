package org.interview.questions.others;

import java.util.*;

public class TripletsSum {
    public static int countTriplets(int t, int[] d) {
        Arrays.sort(d); // sort the array to use two-pointer technique
        int n = d.length;
        int count = 0;

        // For each element, try to find pairs (left, right) such that d[i] + d[left] + d[right] <= t
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = d[i] + d[left] + d[right];
                if (sum <= t) {
                    // Since the array is sorted, all indices k from left+1 to right will
                    // satisfy d[i] + d[left] + d[k] <= t.
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read threshold
        int t = scanner.nextInt();

        // Read array size
        int n = scanner.nextInt();
        int[] d = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }

        // Calculate and print the result
        int result = countTriplets(t, d);
        System.out.println(result);

        scanner.close();
    }
}

