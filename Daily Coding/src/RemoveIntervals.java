import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode 1272
//
public class RemoveIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        // [1, 3] [4, 8]  re [2, 6]
        while(i < intervals.length && intervals[i][1] < toBeRemoved[0]){
            list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        // [1, 3] [4, 8]  re [10, 12]
        if(i == intervals.length) return list;
        //[1, 3] [4, 8]  re [7, 12]
        if(intervals[i][0] < toBeRemoved[0]){
            list.add(Arrays.asList(intervals[i][0], toBeRemoved[0]));
        }
        //[1, 3] [4, 8]  re [5, 16]
        while(i < intervals.length){
            if(intervals[i][1] > toBeRemoved[1] && toBeRemoved[1] > intervals[i][0]){
                list.add(Arrays.asList(toBeRemoved[1], intervals[i][1]));
            }else if(intervals[i][0] > toBeRemoved[1]){
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            i++;
        }
        return list;
    }

}
