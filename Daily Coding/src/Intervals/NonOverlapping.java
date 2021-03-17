package Intervals;
import java.util.Arrays;
//leetcode 435
public class NonOverlapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0, prev = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[prev][1]){
                if(intervals[prev][1] > intervals[i][1]){
                    prev = i;
                }
                result++;
            }else{
                prev = i;
            }
        }
        return result;
    }

}
