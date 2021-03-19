package DP;
import java.util.Arrays;

public class LongestOneCross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestOneCross sol = new LongestOneCross();
		int[][] matrix = {{0,0,0,0,0,0},
				{1,1,1,1,1,1},
				{0,0,0,1,0,0},
				{1,1,1,1,1,1},
				{0,0,0,1,0,0},
				{0,0,0,1,0,0}};
		System.out.println(sol.largest(matrix));

	}
	private int largest(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] MLR = leftRight(matrix, row, col);
		int[][] MRL = rightLeft(matrix, row, col);
		int[][] MTD = topDown(matrix, row, col);
		int[][] MDT = downTop(matrix, row, col);
		int maxCross = 0;
		for(int i = 0; i <= row - 1; i++) {
			for(int j = 0; j <= col - 1; j++) {
				int min = Math.min(MLR[i][j], MRL[i][j]);
				min = Math.min(min, MTD[i][j]);
				min = Math.min(min, MDT[i][j]);
				maxCross = Math.max(maxCross, min);
			}
		}
		return maxCross;
		
	}
	private int[][] rightLeft(int[][] matrix, int row, int col){
		int[][] M = new int[row][col];
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				if(j != 0) {
					M[i][j] = matrix[i][j] == 0? 0 : M[i][j - 1] + 1;
				}else {
					M[i][j] = matrix[i][j];
				}
				
			}
		}
		return M;
	}
	private int[][] leftRight(int[][] matrix, int row, int col){
		int[][] M = new int[row][col];
		for(int i = 0; i <= row - 1; i++){
			for(int j = col - 1; j >= 0; j--){
				if(j != col - 1) {
					M[i][j] = matrix[i][j] == 0? 0 : M[i][j + 1] + 1;
				}else {
					M[i][j] = matrix[i][j];
				}
			}
		}
		return M;
	}
	private int[][] topDown(int[][] matrix, int row, int col){
		int[][] M = new int[row][col];
		for(int i = row - 1; i >= 0; i--){
			for(int j = col - 1; j >= 0; j--){
				if(i != col - 1) {
					M[i][j] = matrix[i][j] == 0? 0 : M[i+ 1][j] + 1;
				}else {
					M[i][j] = matrix[i][j];
				}
			}
		}
		return M;
	}
	private int[][] downTop(int[][] matrix, int row, int col){
		int[][] M = new int[row][col];
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				if(i != 0) {
					M[i][j] = matrix[i][j] == 0? 0 : M[i - 1][j] + 1;
				}else {
					M[i][j] = matrix[i][j];
				}
			}
		}
		return M;
	}
}
