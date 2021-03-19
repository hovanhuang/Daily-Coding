package Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum sol = new ThreeSum();
		int[] array = {-1,0,2, 3, 5, 6};
		int target = 5;
		System.out.println(sol.allTriples(array, target));
	}
	public List<List<Integer>> allTriples(int[] array, int target) {
	    // Write your solution here
	    
	    List<List<Integer>> result = new ArrayList<>();
	    for(int i = 0; i < array.length; i++){
	    	Map<Integer, Integer> map = new HashMap<>();
	      for(int j = i + 1; j < array.length; j++){
	        List<Integer> twoList = new ArrayList<>();
	        int diff = target - array[i] - array[j];
	        if(map.get(diff) != null && map.get(diff) != 1){
	          map.put(diff, 1);
	          map.put(array[j], 1);
	          map.put(array[i], 1);
	          twoList.add(diff);
	          twoList.add(array[j]);
	          twoList.add(array[i]);
	          result.add(twoList);
	        }
	        if(map.get(array[j]) == null){
	          map.put(array[j], 0);
	        }
	      }
	    }
	    return result;
	  }

}
