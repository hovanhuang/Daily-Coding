package DFS;

public class DisjointWhite {
	private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointWhite sol = new DisjointWhite();
		int[][] matrix = {{1,0,1,0,0},
						  {1,0,0,1,0},
						  {0,0,1,0,0},
						  {0,0,0,1,0},
						  {0,1,0,0,0}};
		System.out.println(sol.whiteObjects(matrix));
	}
	public int whiteObjects(int[][] matrix) {
	    // Write your solution here
	    int result = 0;
	    int row = matrix.length;
	    int col = matrix[0].length;
	    int[][] visited = new int[row][col];
	    for(int i = 0; i < row; i++){
	      for(int j = 0; j < col; j++){
	        if(matrix[i][j] == 0 && visited[i][j] == 0){
	          dfs(matrix, visited, i, j);
	          result++;
	        }
	      }
	    }
	    return result;
	  }
	  private void dfs(int[][] matrix, int[][] visited, int row, int col){
	    if(row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length -1){
	      return;
	    }
	    if(matrix[row][col] == 1 || visited[row][col] == 1){
	      return;
	    }
	    visited[row][col] = 1;
	    for(int i = 0; i < directions.length; i++){
	      int newRow = row + directions[i][0];
	      int newCol = col + directions[i][1];
	      dfs(matrix, visited, newRow, newCol);
	    }
	  }

}
