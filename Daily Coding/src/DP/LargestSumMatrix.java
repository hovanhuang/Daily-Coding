package DP;

public class LargestSumMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSumMatrix sol = new LargestSumMatrix();
		int[][] matrix = {{-4,2,-1,0,2},
						  {2,3,2,1,-3},
						  {-3,-3,-2,2,4},
						  {1,1,2,-2,5},
						  {-4,0,1,1,-4}};
		System.out.println(sol.largest(matrix));
	}
	public int largest(int[][] matrix) {
		// Write your solution here
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] preSum = premitiveSum(matrix, row, col);
		int[] array = new int[col];
		int globalMax = Integer.MIN_VALUE;
		for(int i = 0; i <= row - 1; i++){
			for(int j = row -1; j >= i; j--){
				for(int k = 0; k <= col - 1; k++){
					array[k] = i == 0? preSum[j][k] : preSum[j][k] - preSum[i -1][k];
				}
				globalMax = Math.max(globalMax, largestSum(array));
			}
		}
		return globalMax;
	}
	public int[][] premitiveSum(int[][] matrix, int row, int col){
		int[][] preSum = new int[row][col];
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				preSum[i][j] = i==0? matrix[i][j] : preSum[i - 1][j] + matrix[i][j];
			}
		}
		return preSum;
	}
	public int largestSum(int[] array){
		int globalMax = Integer.MIN_VALUE;
		int pre = 0;
		for(int i = 0; i <= array.length - 1; i++){
			pre = pre < 0? array[i] : array[i] + pre;
			globalMax = Math.max(globalMax, pre);
		}
		return globalMax;
	}

}
