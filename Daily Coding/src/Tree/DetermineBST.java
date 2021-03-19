package Tree;
// Given a post order traversal of a binary tree. determine if it’s a BST
public class DetermineBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  input = { 3, 7, 8, 5, 12, 14, 13, 16, 20, 18, 15, 10};
		DetermineBST sol = new DetermineBST();
		System.out.println(sol.determineBST(input));
	}
	public boolean determineBST(int[] input){
		return helper(input, input.length - 1, 0, Integer.MAX_VALUE);
	}
	private boolean helper(int[] input, int rootId, int lB, int max){
		if(rootId == lB || lB < 0 || rootId <= 0){
			return true;
		}	
		int cur = rootId - 1;
		while(cur >= 0 && input[cur] > input[rootId]){
			if(input[cur] > max) return false;
			cur--;
		}
		if(!helper(input, cur, lB, input[rootId])){
			return false;
		}
		if(!helper(input, rootId - 1, cur - 1,  max)){
			return false;
		}
		return true;
	}
}
