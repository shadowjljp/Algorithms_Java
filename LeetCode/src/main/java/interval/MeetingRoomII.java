package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// dealing with interval sequence
		Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
		queue.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= queue.peek()) {
				queue.poll();
			}
			queue.add(intervals[i][1]);
		}

		return queue.size();

	}

	public static void main(String[] args) {
		MeetingRoomII m = new MeetingRoomII();
		//int[][] intervals = { { 0, 30 },{5,10 },{15,20}};
		int[][] intervals = { { 2,4 },{7,10 }};
		
		System.out.println(	m.minMeetingRooms(intervals));
	

	}
}