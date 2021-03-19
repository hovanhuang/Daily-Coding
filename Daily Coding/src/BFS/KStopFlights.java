package BFS;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class CurCity{
	int name;
	int cost;
	CurCity(int name, int cost){
		this.name = name;
		this.cost = cost;
	}
}
public class KStopFlights {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KStopFlights sol = new KStopFlights();
		int[][] flight = {{0,1,11},{0,2,12},{0,3,26},{0,4,24},{1,2,3},{1,3,29},{1,4,25},{2,3,16},{2,4,8},{3,4,14}};
		int n = 5;
		int result = sol.findCheapestcost(n, flight, 1, 4, 10);
		System.out.println(result);
	}
	public int findCheapestcost(int n, int[][] flights, int src, int dst, int k) {
		// Write your solution here
		PriorityQueue<CurCity> minHeap = new PriorityQueue<>(new Comparator<CurCity>(){
			@Override
			public int compare(CurCity s1,CurCity s2){
				return s1.cost == s2.cost ? 0 : s1.cost < s2.cost ? -1 : 1;
			}
		});
		List<int[]> flightRoutes = parseData(n, flights);
		CurCity start = new CurCity(src, 0);
		minHeap.offer(start);
		int cheapest = Integer.MAX_VALUE;
		boolean[] check = new boolean[n];
		check[src] = true;
		while(!minHeap.isEmpty() && k >= 0) {
			CurCity search = minHeap.poll();
			int[] neighbors = flightRoutes.get(search.name);
			for(int i = 0; i <= neighbors.length - 1; i++) {
				if(neighbors[i] != 0 && check[i] == false) {
					int updateCost;
					if(flightRoutes.get(search.name)[i] != 0) {
						updateCost = Math.min(flightRoutes.get(search.name)[i], search.cost + neighbors[i]);
					}
					updateCost = search.cost + neighbors[i];
					CurCity curDst = new CurCity(i, updateCost);
					minHeap.offer(curDst);
					if(curDst.name == dst) {
						cheapest = Math.min(cheapest, curDst.cost);
					}
				}
			}
			k--;
		}
		return cheapest;

	}

	List<int[]> parseData(int n, int[][] flights){
		List<int[]> adj = new ArrayList<int[]>(n);
		for(int i = 1; i <=n; i++){
			int[] list = new int[n];
			adj.add(list);
		}
		for(int i = 0; i <= flights.length - 1; i++) {
			int src = flights[i][0];
			int dst = flights[i][1];
			int cost = flights[i][2];
			adj.get(src)[dst] = cost;

		}
		return adj;
	}


}

