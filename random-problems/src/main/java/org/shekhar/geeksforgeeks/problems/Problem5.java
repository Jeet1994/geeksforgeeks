package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;

/**
 * Write a program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly x.
 * <p>
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class Problem5 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        Arrays.sort(arr);
        int sum = 16;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == sum) {
                System.out.println(arr[l] + " , " + arr[r]);
                return;
            } else if (arr[l] + arr[r] < sum) {
                l++;
            } else {
                r--;
            }
        }

    }
}
