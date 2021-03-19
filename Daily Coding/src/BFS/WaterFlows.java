package BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Given N*N matrix, each element in the matrix stands for the elevation of the current position. 
//water can flow from high elevation to the lower or equal elevation. imagine the top and left board are
//pacific. the right and bottom boarder are alantic. find all the positions that allows water flows to both
//pacific and alantic.

public class WaterFlows {
	class Pair{
		int row;
		int col;
		int value;
		boolean[] check;
		Pair(int row, int col, int value){
			this.row = row;
			this.col = col;
			this.value = value;
			this.check = new boolean[2];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaterFlows sol = new WaterFlows();
		int[][] matrix = {{0,0,0,0,0,0},
				          {0,5,5,5,5,0},
				          {0,5,1,1,5,0},
				          {0,5,1,5,5,0},
				          {0,5,5,5,5,0},
				          {0,0,0,0,0,0}};
		List<int[]> result = sol.findFlow(matrix);
//		for(int[] ele: result) {
//			if(ele[0] != 0 && ele[1] != 0 && ele[0] != 5 && ele[1] != 5) {
//				System.out.println(Arrays.toString(ele));
//			}
//			
//		}
		
	}
	private List<int[]> findFlow(int[][] matrix){
		List<int[]> result = new ArrayList<>();
		Queue<Pair> queue = new LinkedList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visitedP = new boolean[row][col];
		queue.offer(new Pair(0,0,matrix[0][0]));
		List<Pair> pList = new ArrayList<>();
		visitedP[0][0] = true;
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			visitedP[cur.row][cur.col] = true;
			pList.add(cur);
			if(cur.row == 0 || cur.col == 0){
				cur.check[0] = true;
			}else{
				if(cur.value >= matrix[cur.row - 1][cur.col] || cur.value >= matrix[cur.row][cur.col - 1]) {
					cur.check[0] = true;
				}else {
					cur.check[0] = false;
				}
			}
			if(cur.row < row - 1 && cur.col + 1 < col - 1 && !visitedP[cur.row][cur.col + 1]) {
				queue.offer(new Pair(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visitedP[cur.row][cur.col + 1] = true;
			}
			if(cur.row + 1 < row - 1 && cur.col < col - 1 && !visitedP[cur.row + 1][cur.col]) {
				queue.offer(new Pair(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visitedP[cur.row + 1][cur.col] = true;
			}
		}
		for(Pair p: pList) {
			if(p.check[0]) {
				int[] found = {p.row, p.col};
				result.add(found);
				System.out.println(p.row + " " + p.col);
			}
		}	
		return result;
	}

}
