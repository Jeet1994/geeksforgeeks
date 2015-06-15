package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.
 * <p>
 * http://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 */
public class Problem6 {

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 10, 2, 5};
//        int[] arr = {1, 3, 0, 2, 5};

        String[] out = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                out[i] = "_";
            } else {
                int smallest = arr[i - 1];
                if (smallest < arr[i]) {
                    out[i] = String.valueOf(smallest);
                }else {
                    String val = "_";
                    for (int j = i-1; j >= 0; j--) {
                        if(arr[j] < arr[i]){
                            val = String.valueOf(arr[j]);
                            break;
                        }
                    }
                    out[i] = val;
                }
            }
        }

        System.out.println(Arrays.toString(out));
    }
}
