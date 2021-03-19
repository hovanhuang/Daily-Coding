package BFS;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Board{
	private final static int Row = 2;
	private final static int Col = 4;
	private int[][] board = new int[Row][Col];
	public Board(int[] input){
		for(int i = 0; i < input.length; i++){
			this.board[i/Col][i%Col] = input[i];
		}
	}
	public int hashCode() {
		int hashNum = 0;
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++) {
				hashNum += board[i][j]*(i+31)*(j+7);
			}
		}
		return hashNum;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Board)) {
			return false;
		}
		Board b = (Board) o;
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++) {
				if(board[i][j] != b.board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public void swap(int oldR, int oldC, int newR, int newC) {
		int temp = this.board[oldR][oldC];
		this.board[oldR][oldC] = this.board[newR][newC];
		this.board[newR][newC] = temp;
	}
	public boolean outOfBound(int i, int j) {
		return (i >= Row || j >= Col || i < 0 || j < 0);
	}
	public int[] findZero() {
		int[] result = new int[2];
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++) {
				if(board[i][j] == 0) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
	}
	public Board clone() {
		int[] cloneArr = new int[Row * Col];
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++) {
				cloneArr[i*Col + j] = this.board[i][j];
			}
		}
		return new Board(cloneArr);
	}

}
public class SevenPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SevenPuzzle sol = new SevenPuzzle();
		int[] input = {1,5,4,3,2,7,6,0};
		System.out.println(sol.numOfSteps(input));

	}
	public int numOfSteps(int[] values) {
		Queue<Board> queue = new LinkedList<>();
		Map<Board, Integer> map = new HashMap<>();
		Board goal = new Board(new int[] {0, 1, 2, 3, 4, 5, 6, 7});
		int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		queue.offer(goal);
		map.put(goal, 0);
		while(!queue.isEmpty()) {
			Board cur = queue.poll();
			int steps = map.get(cur);
			
			int[] zero = cur.findZero();
			int zeroR = zero[0];
			int zeroC = zero[1];
			
			for(int[] ele : DIRS) {
				int moveR = zeroR + ele[0];
				int moveC = zeroC + ele[1];
				if(!cur.outOfBound(moveR, moveC)) {
					cur.swap(zeroR, zeroC, moveR,moveC);
					if(!map.containsKey(cur)) {
						Board newBoard = cur.clone();
						queue.offer(newBoard);
						map.put(newBoard, steps + 1);
					}
					cur.swap(zeroR, zeroC, moveR,moveC);
				}
 			}
		}
		return map.getOrDefault(new Board(values), -1);
		
	}

}
