package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;

/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array.
 * Traverse array only once.
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        int[] sortedArray = new int[arr.length];
        for (int i = zeroCount; i < sortedArray.length; i++) {
            sortedArray[i] = 1;
        }

        System.out.println(Arrays.toString(sortedArray));
    }
}
