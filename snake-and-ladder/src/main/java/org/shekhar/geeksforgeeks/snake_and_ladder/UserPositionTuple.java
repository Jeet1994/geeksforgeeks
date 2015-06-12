package org.shekhar.geeksforgeeks.snake_and_ladder;

public class UserPositionTuple {
        private int first;
        private int second;

        public UserPositionTuple(int userPosition, int size) {
            first = (userPosition-1) / size;
            second = (userPosition - 1) % size;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

    }