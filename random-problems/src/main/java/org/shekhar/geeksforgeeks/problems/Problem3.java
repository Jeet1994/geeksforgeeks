package org.shekhar.geeksforgeeks.problems;

import java.util.Stack;

/**
 * you are given a 1d array. The values represent the height of wall from floor.
 * We are supposed to find what will be the amount of water it can hold.
 * For ex.. Array(1,0,3) can hold 1 unit of water. Array(3,1,3) can hold 2 units of water.
 * <p>
 * http://coding-interview-archives.blogspot.in/2013/09/water-tower-problem.html
 */
public class Problem3 {

    public static void main(String[] args) {
        int[] heights = {3, 4, 2, 5};

        Stack<Integer> stack = new Stack<>();
        int totalAmountOfWater = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] <= heights[stack.peek()]) {
                System.out.println("Pushed on stack " + i);
                stack.push(i);
            } else {
                while (heights[stack.peek()] <= heights[i]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    totalAmountOfWater += (heights[stack.peek()] - heights[top]) * (i - 1 - stack.peek());
                }

                if (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    totalAmountOfWater -= (heights[stack.peek()] - heights[i]) * (i - 1 - stack.peek());
                }
                stack.push(i);
            }
        }
        System.out.println(totalAmountOfWater);
    }
}
