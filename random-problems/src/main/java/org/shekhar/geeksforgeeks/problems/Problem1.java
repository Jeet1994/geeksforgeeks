package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given two sorted arrays A, B of size m and n respectively.
 * Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.
 * http://articles.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] first = IntStream.of(1, 3, 10).toArray();
        int[] second = IntStream.of(2, 4, 6, 9, 11).toArray();

        System.out.println(findKthLargest_trivial(first, second, 4));

    }

    private static int findKthLargest_trivial(int[] first, int[] second, int k) {
        int[] third = new int[first.length + second.length];

        int filledIndex = 0;
        for (int i = 0; i < first.length; i++) {
            third[filledIndex] = first[i];
            filledIndex++;
        }

        for (int i = 0; i < second.length; i++) {
            third[filledIndex] = second[i];
            filledIndex++;
        }
        Arrays.sort(third);
        return third[k - 1];
    }
}
