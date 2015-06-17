package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;

/**
 * Given an almost sorted array where only two elements are swapped, how to sort the array efficiently?
 * <p>
 * http://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
 */
public class Problem7 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 30, 50, 60};


        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                while (j >= 0 && arr[i] < arr[j]) {
                    j--;
                }

                int c = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = c;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
