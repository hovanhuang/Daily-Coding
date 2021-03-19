package DP;

public class MaxWaterTrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,3,1,4,6,2,3};
		System.out.println(MaxWaterTrap.maxTrapped(input));

	}
	public static int maxTrapped(int[] array) {
		// Write your solution here
		int[] leftMax = new int[array.length];
		int[] rightMax = new int[array.length];
		int i = 0;
		int j = array.length - 1;
		while(j >= 0 || i < array.length){
			leftMax[i] = i == 0 ? array[i] : array[i] > leftMax[i - 1] ? array[i] : leftMax[i - 1];
			rightMax[j] = j == array.length - 1? array[j] : 
				array[j] > rightMax[j + 1] ? array[j] : rightMax[j + 1];
				i++;
				j--;
		}
		int sum = 0;
		for(int t = 0; t < array.length; t++){
			int diff = Math.min(leftMax[t], rightMax[t]) - array[t];
			if(diff > 0){
				sum += diff;
			}
		}
		return sum;
	}

}
