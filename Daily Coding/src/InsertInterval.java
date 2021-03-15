import java.util.ArrayList;
import java.util.List;

//LeetCode 57
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

//You may assume that the intervals were initially sorted according to their start times.
public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int id = 0;

        while(id < intervals.length && intervals[id][1] < newInterval[0]){
            list.add(intervals[id++]);
        }
        //e.g.[1, 3] new [4, 5]
        if(id == intervals.length){
            list.add(newInterval);
            return list.toArray(new int[list.size()][2]);
        }
        //e.g[0, 10] new [1, 2]
        if(newInterval[1] <= intervals[id][1] && intervals[id][0] <= newInterval[0]) return intervals;
        int[] toAdd = new int[2];
        if(intervals[id][0] > newInterval[1]){// e.g.[0, 1], [4, 5] new [2, 3]
            toAdd = newInterval;
        }else{//e.g.[0, 1], [4, 6], [8,  10] new [5, 9]
            toAdd = new int[]{Math.min(intervals[id][0], newInterval[0]), Math.max(newInterval[1], intervals[id][1])};
        }
        boolean added = false;
        while(id < intervals.length){
            if(intervals[id][0] <= toAdd[1] && intervals[id][1] > toAdd[1]){
                toAdd[1] = intervals[id][1];
            }else if(intervals[id][0] > toAdd[1]){
                if(!added){
                    list.add(toAdd);
                    added = true;
                }
                list.add(intervals[id]);
            }
            id++;
        }
        if(!added) list.add(toAdd);

        return list.toArray(new int[list.size()][2]);
    }

}
