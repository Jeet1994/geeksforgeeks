package org.shekhar.geeksforgeeks.snake_and_ladder;

public class UserPositionTuple {
        private int first;
        private int second;

        public UserPositionTuple(int userPosition) {
            first = (userPosition-1) / 10;
            second = (userPosition - 1) % 10;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

    }