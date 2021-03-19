package DFS;
import java.util.ArrayList;
import java.util.List;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] coins = {34,31,2};
		int target = 100;
		List<List<Integer>> result = new ArrayList<>();
	    List<Integer> count = new ArrayList<>();
	    System.out.println(findCoin(count, coins, 0, result, target));

	}
	static List<List<Integer>> findCoin(List count, int[] coins, int index, List<List<Integer>> result, int rem){
		// if(index == coins.length - 1){
		//   if (rem % coins[coins.length - 1] == 0){
		//     count.add(rem / coins[coins.length - 1]);
		//     result.add(new ArrayList<Integer>(count));
		//     count.remove(count.size() - 1);
		//   }
		//   return result;
		// }
		if(index == coins.length){
			if(rem == 0){
				result.add(new ArrayList(count));
			}
			return result;
		}
		for(int i = 0; i <= rem/coins[index]; i++){
			count.add(i);
			findCoin(count, coins, index + 1, result, rem - coins[index]*i);
			count.remove(count.size() - 1);
		}
		return result;
	}

}
