package DP;

public class LongestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestOne sol = new LongestOne();
		int[] input = {1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1};
		System.out.print(sol.longest(input));

	}
	int longest(int[] array) {
		int pre = 0;
		int max = 0;
		for(int i = 0; i <= array.length - 1; i++) {
			pre = array[i] == 0? 0 : pre + 1;
			max = Math.max(max, pre);
 		}
		return max;
	}
}
