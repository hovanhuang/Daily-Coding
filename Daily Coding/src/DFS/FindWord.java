package DFS;

public class FindWord {
	boolean res = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindWord sol = new FindWord();
		Character[][] input = {{'A', 'B','C','D','E'},
						       {'A', 'A','A','B','E'},
						       {'A', 'D','C','A','D'},
						       {'E', 'B','A','E','E'},
					           {'A', 'E','C','B','C'}};
		String inputStr = "ABADCADECBCA";
		System.out.println(sol.findWord(input, inputStr));
		
	}
	private boolean findWord(Character[][] input, String inputStr){
		int row = input.length;
		int col = input[0].length;
		
 		for(int i = 0; i<= row - 1; i++) {
			for(int j = 0; j <= col - 1; j++) {
				int[][] check = new int[row][col];
				findWordMain(input, inputStr, i, j, 0, check);
				if(res) {
					return true;
				}
			}
		}
		return false;
	}
	private void findWordMain(Character[][] input, String inputStr, int startRow, int startCol, int level, int[][] check){
		if(level == inputStr.length()) {
			res = true;
			return;
		}
		if(startRow < 0 || startRow >= input.length || startCol < 0 || startCol >=input.length) {
			return;
		}
		if(input[startRow][startCol] != inputStr.charAt(level) || check[startRow][startCol] == 1) {
			return;
		}
			
		check[startRow][startCol] = 1;
		findWordMain(input, inputStr, startRow + 1, startCol, level + 1, check);
		findWordMain(input, inputStr, startRow, startCol + 1, level + 1, check);
		findWordMain(input, inputStr, startRow - 1, startCol, level + 1, check);
		findWordMain(input, inputStr, startRow, startCol - 1, level + 1, check);
		check[startRow][startCol] = 0;
	}

}
