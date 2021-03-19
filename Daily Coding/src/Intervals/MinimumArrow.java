package Intervals;

import java.util.Arrays;

//LeetCode 452
public class MinimumArrow {
	public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0],b[0]));
        int[] cur = points[0];
        int count = 1, i = 1;
        while(i < points.length){
            if(points[i][0] > cur[1]){
                count++;
                cur = points[i];
            }else{
                cur[0] = points[i][0];
                cur[1] = Math.min(cur[1], points[i][1]);
            }
            i++;
        }
        return count;
    }
}
