package DFS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrieSearch {
	int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
	class TrieNode{
		Map<Character, TrieNode> children;
		boolean isWord;
		TrieNode(){
			children = new HashMap<>();
		}
		public TrieNode insert(String str, TrieNode root){
			if(str == null || str.length() == 0){
				return null;
			}
			TrieNode curNode = root;
			for(int i = 0; i < str.length(); i++){
				char curChar = str.charAt(i);
				TrieNode next = curNode.children.get(curChar);
				if(next == null){
					next = new TrieNode();
					curNode.children.put(curChar, next);
				}
				curNode = next;
			}
			curNode.isWord = true;
			return root;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieSearch sol = new TrieSearch();
		String[] input = {"accacd","caea","dcd","acede","ceedd","aa","eeacda","bb"};
		char[][] board = {{'b','c','e','e','d'},
						  {'b','b','e','a','e'},
						  {'e','b','c','c','a'},
						  {'a','c','e','c','c'},
						  {'a','b','c','d','c'}};
		System.out.println(sol.findWords(board, input));
	}
	public List<String> findWords(char[][] board, String[] words) {
		// Write your solution here
		Set<String> result = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		TrieNode root = new TrieNode();
		for(String str : words) {
			root.insert(str, root);
		}
		int row = board.length;
		int col = board[0].length;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				boolean[][] visited = new boolean[row][col];
				dfs(board, i, j, root, result, sb, visited);
			}
		}
		List<String> fresult = new ArrayList<>();
		for(String s: result) {
			fresult.add(s);
		}
		return fresult;
		
	}
	
	private void dfs(char[][] board,int i, int j, TrieNode root, Set<String> result, StringBuilder sb, boolean[][] visited){
		if(root == null) {
			return;
		}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}
		if(visited[i][j]) {
			return;
		}
		if(root.isWord) {
			result.add(sb.toString());
			return;
		}
		visited[i][j] = true;
		sb.append(board[i][j]);
		for(int step = 0; step < directions.length; step++) {
			int newX = i + directions[step][0];
			int newY = j + directions[step][1];
			TrieNode next = root.children.get(board[i][j]);
			dfs(board, newX, newY, next, result, sb, visited);
		}
		sb.deleteCharAt(sb.length() - 1);
	}

}
