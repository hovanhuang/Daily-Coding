package Intervals;

import java.util.Arrays;
//LeetCode 1288
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0, i = 1;
        int[] cur = intervals[0];
        while(i < intervals.length){
            if(intervals[i][1] <= cur[1]){
                result++;
            }else if(intervals[i][1] >= cur[1] && intervals[i][0] == cur[0]){
                result++;
                cur = intervals[i];
            }else{
                cur = intervals[i];
            }
            i++;
        }
        return intervals.length - result;
    }
}
