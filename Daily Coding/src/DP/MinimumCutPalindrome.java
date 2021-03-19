package DP;

public class MinimumCutPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCutPalindrome sol = new MinimumCutPalindrome();
		String input = "abadadeec";
		System.out.println(sol.minCut(input));

	}
	public int minCut(String input){
		int[] M = new int[input.length()];
		M[0] = 0;
		for(int i = 1; i <= input.length() - 1; i++){
			int minCut = Integer.MAX_VALUE;
			for(int j = i; j >= 0; j--){	
				if(checkPalindrome(input, j, i)){
					minCut = j== 0? 0: Math.min(minCut, M[j - 1] + 1);
				}
			}
			M[i] = minCut;
		}
		return M[input.length() - 1];
	}
	boolean checkPalindrome(String input, int start, int end){
		while(start <= end){
			if(input.charAt(start) != input.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
