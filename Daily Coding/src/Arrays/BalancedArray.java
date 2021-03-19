package Arrays;
//Given an array, find the pivot index such that the left sum of the pivot is equal to the right sum;	
public class BalancedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedArray sol = new BalancedArray();
		int[] input = {1,4,6,2,2,3,0,8,5,5};
		System.out.println(sol.balance(input));
	}
	public int balance(int[] array) {
		int[] prefix = prefixSum(array);
		for(int pivot = 0; pivot < array.length; pivot++) {
			int leftSum = prefix[pivot] - array[pivot];
			int rightSum = prefix[prefix.length - 1] - prefix[pivot];
			if(leftSum == rightSum) {
				return pivot;
			}
		}
		return -1;
		
	}
	private int[] prefixSum(int[] array) {
		int[] pref = new int[array.length];
		pref[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			pref[i] = array[i] + pref[i - 1];
		}
		return pref;
	}

}
