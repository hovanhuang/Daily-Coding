package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
public class MeetingRoomII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.offer(intervals[0]);
		int meetR = 1;
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i][0] >= pq.peek()[1]){
				pq.poll();
			}
			pq.offer(intervals[i]);
			meetR = Math.max(meetR, pq.size());
		}
		return meetR;
	}
}
