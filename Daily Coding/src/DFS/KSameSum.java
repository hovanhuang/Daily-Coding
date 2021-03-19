package DFS;
import java.util.ArrayList;
import java.util.List;

// given an input array with integers, divided into K subarrays such that each subarray sum is the same;
public class KSameSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSameSum sol = new KSameSum();
		int[] input = {3, -1, 4, 6, -8, 1, 1};
		int k = 3;
		System.out.println(sol.KSameSum(input, k));
	}
	public List<List<Integer>> KSameSum(int[] input, int k){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> indexList = new ArrayList<>();
		int[] prefix = prefixSum(input);
		int Ksum = prefix[prefix.length - 1] / k;
		dfs(prefix, indexList, 0, Ksum, k, result);
		return result;
		
	}
	void dfs(int[] prefix, List<Integer> list, int start_index, int sum, int k, List<List<Integer>> result) {
		if(start_index == prefix.length) {
			return;
		}
		if(list.size() == k - 1) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = start_index; i < prefix.length; i++) {
			if(list.size() == 0) {
				if(prefix[i] == sum) {
					list.add(i);
					dfs(prefix, list, i + 1, sum, k, result);
					list.remove(list.size() - 1);
				}
			}else {
				if(prefix[i] - prefix[start_index - 1] == sum) {
					list.add(i);
					dfs(prefix, list, i + 1, sum, k, result);
					list.remove(list.size() - 1);
				}
			}
		}
	}
	int[] prefixSum(int[] array) {
		int[] result = new int[array.length];
		for(int i = 0; i < result.length; i++) {
			if(i == 0) {
				result[i] = array[i];
			}else {
				result[i] = result[i - 1] + array[i];
			} 
		}
		return result;
	}
}
