package BFS;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class City{
	int name;
	int cost;
	City(int name, int cost){
		this.name =name;
		this.cost = cost;
	}
}
public class KStopFlightsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KStopFlightsII sol = new KStopFlightsII();
		int[][] flight = {{0,1,11},{0,2,2},{0,3,5},{0,4,24},{1,2,3},{1,3,29},{1,4,25},{2,3,16},{2,4,8},{3,4,14}};
		int n = 5;
		int result = sol.Kstop(flight, n, 0, 4, 40);
		System.out.println(result);
	}
	int Kstop(int[][] flight, int n, int src, int dst, int k) {
		List<List<City>> data = parseData(n, flight);
		PriorityQueue<City> minHeap = new PriorityQueue<>(new Comparator<City>(){
			@Override
			public int compare(City s1, City s2){
				return s1.cost == s2.cost ? 0 : s1.cost < s2.cost ? -1 : 1;
			}
		});
		City start = new City(src, 0);
		minHeap.offer(start);
		while(minHeap.peek().name != dst && k >= 0) {
			City cur = minHeap.poll();
			for(City nei: data.get(cur.name)) {
				City stop = new City(nei.name, cur.cost + nei.cost);
				minHeap.offer(stop);
			}
			k--;
		}
		while(!minHeap.isEmpty()){
			if(minHeap.peek().name == dst){
				return minHeap.peek().cost;
			}
			minHeap.poll();
		}
		return -1;
	}

	List<List<City>> parseData(int n, int[][] flight){
		List<List<City>> data = new ArrayList<>(n);
		for(int i = 0; i <= n - 1; i++) {
			data.add(new ArrayList<City>());
		}
		for(int[] route : flight) {
			data.get(route[0]).add(new City(route[1], route[2]));
		}
		return data;

	}

}
