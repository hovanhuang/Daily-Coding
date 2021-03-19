package DFS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIsland {
	boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctIsland sol = new DistinctIsland();
		int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
		System.out.print(sol.numDistinctIslands(grid));

	}
	public int numDistinctIslands(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        visited = new boolean[rowNum][colNum];
        Set<List<String>> result = new HashSet<>();
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                List<String> list = new ArrayList<>();
                dfs(i, j, grid, list, i, j);
                if(list.size() > 0){
//                    Collections.sort(list);
                    result.add(list);
                }
            }
        }
        return result.size();
    }
    private void dfs(int curRow, int curCol, int[][] grid, List<String> shape, int row, int col){
        if(curRow < 0 || curCol < 0 || curRow > grid.length - 1 || curCol > grid[0].length - 1 || visited[curRow][curCol]){
            return;
        }
        if(grid[curRow][curCol] != 1){
            return;
        }
        visited[curRow][curCol] = true;
        shape.add((curRow - row) + "," + (curCol - col));
        dfs(curRow + 1, curCol, grid, shape, row, col);
        dfs(curRow , curCol + 1, grid, shape, row, col);
        dfs(curRow - 1, curCol, grid, shape, row, col);
        dfs(curRow, curCol - 1, grid, shape, row, col);
    }

}
