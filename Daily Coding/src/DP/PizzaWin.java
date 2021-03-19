package DP;

public class PizzaWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaWin sol = new PizzaWin();
		int[] input = {18,74,89,72,71, 11, 73};
		System.out.println(sol.canWin(input));
	}
	public int canWin(int[] nums) {
	    // Write your solution here
	    int[][] M = new int[nums.length][nums.length];
	    preProcess(M, nums);
	    for(int j = 2; j < nums.length; j++){
	      int offset = 0;
	      for(int i = 0; i < nums.length - j; i++){
	        int take1 = nums[i];
	        take1 += nums[i + 1] > nums[j + offset]? M[i + 2][j + offset] : M[i + 1][j -1 + offset];
	        int take2 = nums[j + offset];
	        take2 += nums[i] > nums[j - 1 + offset]? M[i + 1][j - 1 + offset] : M[i][j - 2 + offset];
	        M[i][j + offset] = Math.max(take1, take2);
	        offset++;
	      }
	    }
	    return M[0][nums.length - 1];

	  }
	  public void preProcess(int[][] M, int[] nums){
	    for(int i = 0; i < nums.length - 1; i++){
	      M[i][i] = nums[i];
	      M[i][i + 1] = nums[i] > nums[i + 1] ? nums[i] : nums[i + 1];
	    }
	    M[nums.length - 1][nums.length - 1] = nums[nums.length - 1];
	  }

}
