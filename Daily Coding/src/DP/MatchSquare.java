package DP;

public class MatchSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] input = {{3,1,1,2},{2,0,0,2},{2,0,0,0},{1,1,0,0}};
		int[][] input = {{3,2,3,2,2,2},{1,0,0,2,0,2},{0,0,3,2,0,3},{2,3,2,2,3,1},{0,1,0,3,0,0},{0,3,2,1,3,3},{3,3,2,1,0,1},{3,3,2,1,0,1},{0,0,3,0,1,2}};
		MatchSquare sol = new MatchSquare();
		System.out.println(sol.largestSquareOfMatches(input));
	}
	public int largestSquareOfMatches(int[][] matrix) {
	    // Write your solution here
	    int row = matrix.length;
	    int col = matrix[0].length;
	    int[][] left = new int[row][col];
	    int[][] up = new int[row][col];
	    //left[i][j] represents the longest matches edge is to the left ending at this point. 
	    //up[i][j] represents the longest matches edge is to the left ending at this point.
	    int globalMax = 0;
	    for(int i = 0; i <= row - 1; i++){
	      for(int j = 0; j <= col - 1;j++){
	        left[i][j] = j == 0? 0 : (matrix[i][j - 1] == 3 || matrix[i][j - 1] == 1)? left[i][j - 1] + 1 : 0;
	        up[i][j] = i == 0? 0 : (matrix[i - 1][j] == 3 || matrix[i - 1][j] == 2)? up[i-1][j] + 1 : 0;
	        int min = Math.min (left[i][j], up[i][j]);
	        for(int offset = 1; offset <= min; offset++){
	          if(up[i][j - offset] >= offset && left[i - offset][j] >= offset){
	            globalMax = Math.max(globalMax, offset);
	          }
	          if(globalMax == 2) {
	        	  return 1;
	          }
	        }
	      }
	    }
	    return globalMax;
	  }

}
