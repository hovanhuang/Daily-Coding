package DP;
//Determine the largest square surrounded by 
//1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
public class OneSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneSquare sol = new OneSquare();
				int[][] input = {{1,1,1,1,1,1,1,1,0,0,1,1,0,1,1},
						{1,0,1,0,0,1,0,0,0,1,1,1,1,1,1},
						{1,0,0,1,0,0,1,1,1,1,0,1,0,0,1},
						{1,0,1,1,1,1,0,1,1,1,1,1,1,1,0},
						{0,1,0,0,1,1,1,1,0,0,1,1,0,1,0},
						{1,1,1,0,0,1,1,0,1,1,1,0,1,0,1},
						{1,1,1,1,0,0,1,1,0,1,1,1,1,1,0},
						{1,0,0,1,0,1,1,1,1,1,0,1,1,1,0},
						{1,1,1,0,1,1,1,1,0,1,1,1,1,1,0},
						{1,1,1,1,1,1,1,1,0,1,1,0,1,1,1},
						{1,0,0,1,1,1,0,1,0,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,0,0,1,0,1,1,1,1},
						{0,1,1,1,1,1,1,1,1,1,0,1,1,1,1},
						{1,1,1,1,0,1,1,0,1,0,1,1,0,1,1},
						{1,0,1,1,0,1,1,1,1,1,0,1,1,0,0},
						{1,1,1,1,1,0,0,0,1,1,1,0,0,1,1},
						{1,1,1,1,1,1,1,1,0,1,1,0,1,0,0},
						{1,0,1,0,0,1,1,0,1,0,0,1,1,1,1},
						{1,1,1,1,1,0,0,0,1,0,1,1,0,1,0}};
//		int[][] input = {{1,1,1,1,1,0,0},
//				{1,0,1,1,1,0,1},
//				{0,0,1,1,1,0,0},
//				{1,1,1,1,1,1,1},
//				{1,0,1,1,1,1,0},
//				{1,1,1,1,0,1,1},
//				{1,1,1,0,0,1,1},
//				{0,1,1,1,0,1,1},
//				{1,1,0,1,1,1,1},
//				{1,0,1,1,1,0,1},
//				{0,1,1,1,0,1,1},
//				{1,0,0,0,1,0,0},
//				{1,1,1,1,1,0,0},
//				{0,1,0,0,0,1,1},
//				{0,1,1,0,0,1,0},
//				{1,0,1,1,0,1,1},
//				{1,1,1,0,0,1,1},
//				{0,0,1,1,1,0,1},
//				{1,0,0,1,0,1,0},
//				{0,1,0,0,1,1,1},
//				{1,1,1,1,1,1,1},
//				{0,1,1,0,1,0,1},
//				{1,0,1,1,1,1,1},
//				{0,0,1,1,0,1,1}};
		System.out.println(sol.largestSquareSurroundedByOne(input));
	}
	public int largestSquareSurroundedByOne(int[][] matrix) {
		// Write your solution here
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] rightLeft = new int[row][col];
		int[][] bottomUp = new int[row][col];
		int globalMax = 0;
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				if(matrix[i][j] == 1){
					rightLeft[i][j] = j == 0? 1 : rightLeft[i][j - 1] + 1;
					bottomUp[i][j] = i == 0? 1 : bottomUp[i - 1][j] + 1;
				}
				int min = Math.min(rightLeft[i][j], bottomUp[i][j]);
				for(int offset = 1; offset <= min; offset++) {
					if(min != 0 && rightLeft[i][j - offset + 1] >= offset && bottomUp[i -offset + 1][j] >= offset){
						globalMax = Math.max(globalMax, offset);
					}
				}
			}
		}
		return globalMax;
	}
}