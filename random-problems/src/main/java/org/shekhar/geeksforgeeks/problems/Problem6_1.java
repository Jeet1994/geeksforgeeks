package org.shekhar.geeksforgeeks.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem6_1 {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();

//        int[] arr = {1, 6, 4, 10, 2, 5};
        int[] arr = {1, 3, 0, 2, 5};
        String[] out = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!numbers.isEmpty() && numbers.peek() >= arr[i]) {
                numbers.pop();
            }

            if (numbers.isEmpty()) {
                out[i] = "_";
            }else{
                out[i] = String.valueOf(numbers.peek());
            }

            numbers.push(arr[i]);
        }

        System.out.println(Arrays.toString(out));
    }
}
