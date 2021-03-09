import java.util.Arrays;

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = Integer.MIN_VALUE;
        for(int[] arr : intervals){
            if(prevEnd > arr[0]) return false;
            prevEnd = arr[1];
        }
        return true;
    }

}
