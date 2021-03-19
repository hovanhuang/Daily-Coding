package DP;

public class ArrayHopperII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayHopperII sol = new ArrayHopperII();
		int[] input = {2,3,4,0};
		System.out.println(sol.minJump(input));
	}
	  public int minJump(int[] array) {
		    // Write your solution here
		    int[] M = new int[array.length];
		    //M[i] represents the minmum steps one needs to take, jumping from index 0 to index i
		    M[0] = 0;
		    if(array[0] > 0){
		      M[1] = 1;
		    }
		    for(int i = 2; i < array.length; i++){
		      int min = Integer.MAX_VALUE;
		      for(int j = i - 1; j >= 0; j--){
		        if(array[j] >= i - j){
		          min = Math.min(min, M[j] + 1);
		        }
		      }
		      M[i] = min;
		      if(M[i] == Integer.MAX_VALUE){
		        return -1;
		      }
		    }
		    return M[array.length - 1];
		  }

}
