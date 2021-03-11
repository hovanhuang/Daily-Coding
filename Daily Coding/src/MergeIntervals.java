import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//LeetCode 56
//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length == 0){
			return new int[0][0];
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int curS = intervals[0][0];
		int curE = intervals[0][1];
		List<int[]> list = new ArrayList<>();
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i][0] > curE){
				list.add(new int[]{curS, curE});
				curS = intervals[i][0];
				curE = intervals[i][1];
			}else{
				curE = Math.max(curE, intervals[i][1]);
			}
		}
		list.add(new int[]{curS, curE});
		int[][] result = new int[list.size()][2];
		for(int i = 0; i < result.length; i++){
			result[i] = list.get(i);
		}
		return result;
	}

}
