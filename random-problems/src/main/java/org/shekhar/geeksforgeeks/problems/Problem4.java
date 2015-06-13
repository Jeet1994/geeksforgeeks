package org.shekhar.geeksforgeeks.problems;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem4 {

    public static void main(String[] args) {
        Meeting meeting1 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 1, 0), LocalDateTime.of(2015, Month.APRIL, 10, 2, 0));
        Meeting meeting2 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 3, 0), LocalDateTime.of(2015, Month.APRIL, 10, 4, 0));
        Meeting meeting3 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 0, 0), LocalDateTime.of(2015, Month.APRIL, 10, 6, 0));
        Meeting meeting4 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 5, 0), LocalDateTime.of(2015, Month.APRIL, 10, 7, 0));
        Meeting meeting5 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 8, 0), LocalDateTime.of(2015, Month.APRIL, 10, 9, 0));
        Meeting meeting6 = new Meeting(LocalDateTime.of(2015, Month.APRIL, 10, 5, 0), LocalDateTime.of(2015, Month.APRIL, 10, 9, 0));
        maxMeetingsAt(Arrays.asList(meeting1, meeting2, meeting3, meeting4, meeting5, meeting6));
    }

    private static void maxMeetingsAt(List<Meeting> meetings) {
        Collections.sort(meetings, (m1, m2) -> m1.getEnd().compareTo(m2.getEnd()));


        Meeting first = meetings.get(0);
        System.out.println(first);

        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
            if (meeting.getStart().isAfter(first.getEnd()) || meeting.getStart().isEqual(first.getEnd())) {
                System.out.println(meeting);
                first = meeting;
            }
        }
    }

    private static class Meeting {

        private final LocalDateTime start;
        private final LocalDateTime end;

        public Meeting(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start.toLocalTime() +
                    ", end=" + end.toLocalTime() +
                    '}';
        }
    }
}
