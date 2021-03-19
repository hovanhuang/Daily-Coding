package BFS;
import java.util.Comparator;
import java.util.PriorityQueue;

class Cell{
	int col;
	int row;
	static int value;
	Cell(int row, int col , int value){
		this.value = value;
		this.row = row;
		this.col = col;
	}

}
class MyComparator1 implements Comparator<Cell>{
	@Override
	public int compare(Cell c1, Cell c2){
		if(c1.value == c2. value){
			return 0;
		}else{
			return c1.value < c2.value ? -1 : 1;
		}
	}

}
public class KthSmallestMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{11,12,13,14},{15,16,17,18},{19,20,21,22}};
		int k = 4;
		System.out.println(kthSmallest(matrix, k));
	}
	public static int kthSmallest(int[][] matrix, int k) {
		// Write your solution here
		int row = matrix.length;
		int col = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(new MyComparator1());
		boolean[][] teller = new boolean[row][col];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		int count = 1;
		teller[0][0] = true;
		while(count <= k) {
			Cell cur = minHeap.poll();
			if(cur.row + 1 < row && !teller[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				teller[cur.row + 1][cur.col] = true;
			}
			if(cur.col + 1 < col && !teller[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				teller[cur.row][cur.col + 1] = true;
			}
			
			count++;
		}
		return minHeap.poll().value;


	}
}
