package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReconItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] input = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<List<String>> list = new ArrayList<>();
		for(String[] arr : input) {
			list.add(Arrays.asList(arr));
		}
		System.out.print(findItinerary(list));
	}
	public static List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0){
            return new ArrayList();
        }
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < tickets.size(); i++){
            List<String> curTicket = tickets.get(i);
            if(curTicket.get(0).equals("JFK")){
                List<String> itinerary = new ArrayList<>();
                itinerary.add("JFK");
                swap(tickets, 0, i);
                dfs(result, tickets, itinerary, 1);
                swap(tickets, 0, i);
            }
        }
        System.out.print(result);
        Collections.sort(result, new Comparator<>(){
            @Override
            public int compare(List<String> l1, List<String> l2){
                for(int i = 0; i < Math.min(l1.size(), l2.size()); i++){
                    if(!l1.get(i).equals(l2.get(i))){
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }
                return 0;
            }
        });
        return result.get(0);
    }
    private static void dfs(List<List<String>> result, List<List<String>> tickets, List<String> itinerary, int index){
        if(index == tickets.size()){
        	itinerary.add(tickets.get(index - 1).get(1));
            result.add(new ArrayList(itinerary));
            itinerary.remove(itinerary.size() - 1);
            return;
        }
        for(int i = index; i < tickets.size(); i++){
            swap(tickets, index, i);
            if(tickets.get(index).get(0).equals(tickets.get(index - 1).get(1))){
            	itinerary.add(tickets.get(index).get(0));
                dfs(result, tickets, itinerary, index + 1);
                itinerary.remove(itinerary.size() - 1);
            }
            swap(tickets, index, i);
        }
        
    }
    private static void swap(List<List<String>> input, int left, int right){
        List<String> temp  =input.get(left);
        input.set(left, input.get(right));
        input.set(right, temp);
    }

}
