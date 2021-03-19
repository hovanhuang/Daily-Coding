package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
	class Pair{
		int left;
		int right;
		Pair(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum sol = new FourSum();
		int[] array = {2,1,1,1,0};
		int target = 3;
		System.out.println(sol.exist(array, target));
	}
	public boolean exist(int[] array, int target) {
	    // Write your solution here
		List<Pair> result = new ArrayList<>();
	    Map<Integer, Pair> map = new HashMap<>();
	    for(int i = 0; i < array.length; i++){
	      for(int j = i + 1; j < array.length; j++){
	        int pairSum = array[i] + array[j];
	        if(map.get(target - pairSum) != null && map.get(target - pairSum).right < i){
	          return true;
	        }
	        if(!map.containsKey(pairSum)){
	          map.put(pairSum, new Pair(i, j));
	        }
	      }
	    }
	    return false;
	  }

}
