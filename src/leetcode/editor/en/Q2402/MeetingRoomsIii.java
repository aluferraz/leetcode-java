package leetcode.editor.en.Q2402;

import java.util.*;

import javafx.util.Pair;

//You are given an integer n. There are n rooms numbered from 0 to n - 1. 
//
// You are given a 2D integer array meetings where meetings[i] = [starti, endi] 
//means that a meeting will be held during the half-closed time interval [starti, 
//endi). All the values of starti are unique. 
//
// Meetings are allocated to rooms in the following manner: 
//
// 
// Each meeting will take place in the unused room with the lowest number. 
// If there are no available rooms, the meeting will be delayed until a room 
//becomes free. The delayed meeting should have the same duration as the original 
//meeting. 
// When a room becomes unused, meetings that have an earlier original start 
//time should be given the room. 
// 
//
// Return the number of the room that held the most meetings. If there are 
//multiple rooms, return the room with the lowest number. 
//
// A half-closed interval [a, b) is the interval between a and b including a 
//and not including b. 
//
// 
// Example 1: 
//
// 
//Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
//Output: 0
//Explanation:
//- At time 0, both rooms are not being used. The first meeting starts in room 0
//.
//- At time 1, only room 1 is not being used. The second meeting starts in room 
//1.
//- At time 2, both rooms are being used. The third meeting is delayed.
//- At time 3, both rooms are being used. The fourth meeting is delayed.
//- At time 5, the meeting in room 1 finishes. The third meeting starts in room 
//1 for the time period [5,10).
//- At time 10, the meetings in both rooms finish. The fourth meeting starts in 
//room 0 for the time period [10,11).
//Both rooms 0 and 1 held 2 meetings, so we return 0. 
// 
//
// Example 2: 
//
// 
//Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
//Output: 1
//Explanation:
//- At time 1, all three rooms are not being used. The first meeting starts in 
//room 0.
//- At time 2, rooms 1 and 2 are not being used. The second meeting starts in 
//room 1.
//- At time 3, only room 2 is not being used. The third meeting starts in room 2
//.
//- At time 4, all three rooms are being used. The fourth meeting is delayed.
//- At time 5, the meeting in room 2 finishes. The fourth meeting starts in 
//room 2 for the time period [5,10).
//- At time 6, all three rooms are being used. The fifth meeting is delayed.
//- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts 
//in room 1 for the time period [10,12).
//Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1
//. 
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 1 <= meetings.length <= 10⁵ 
// meetings[i].length == 2 
// 0 <= starti < endi <= 5 * 10⁵ 
// All the values of starti are unique. 
// 
//
// 👍 530 👎 33


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int START = 1;
    private static final int END = -1;

    public int mostBooked(int n, int[][] meetings) {
        long[] counter = new long[n];
        PriorityQueue<long[]> roomsQueue = new PriorityQueue<>(Arrays::compare);
        LinkedList<int[]> meetingsQueue = new LinkedList<>(Arrays.asList(meetings));
        meetingsQueue.sort(Arrays::compare);
        for (int i = 0; i < n; i++) {
            roomsQueue.add(new long[]{meetingsQueue.peek()[0], END, i});
        }
        while (!roomsQueue.isEmpty()) {
            long[] roomInfo = roomsQueue.poll();

            long currentTime = roomInfo[0];
            int eventType = (int) roomInfo[1];
            int roomId = (int) roomInfo[2];

            switch (eventType) {
                case START:
                    counter[roomId]++;
                    break;
                case END:
                    if (!meetingsQueue.isEmpty()) {
                        int[] meeting = meetingsQueue.peekFirst();
                        long startTime = meeting[0];
                        long endTime = meeting[1];
                        long duration = endTime - startTime;
                        if (startTime <= currentTime) {
                            meetingsQueue.poll();
                            startTime = currentTime;
                            endTime = currentTime + duration;
                            roomsQueue.add(new long[]{startTime, START, roomId});
                            roomsQueue.add(new long[]{endTime, END, roomId});
                        } else {
                            roomsQueue.add(new long[]{startTime, END, roomId});
                        }

                    }
                    break;
            }
        }
        long best = -1;
        int ans = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > best) {
                best = counter[i];
                ans = i;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MeetingRoomsIii extends Solution {
}