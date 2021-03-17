package Intervals;
import java.util.TreeMap;
//LeetCod 732
//A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
//You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.
public class MyCalendarIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	TreeMap<Integer, Integer> timeline;
	int interval;
	public MyCalendarIII() {
		timeline  = new TreeMap<>();
		interval = 0;

	}

	public int book(int start, int end) {
		timeline.put(start, timeline.getOrDefault(start, 0) + 1);
		timeline.put(end, timeline.getOrDefault(end, 0) - 1);
		int result = 0;
		for(int v: timeline.values()){
			interval += v;
			result = Math.max(result, interval);
		}
		return result;
	}

}
