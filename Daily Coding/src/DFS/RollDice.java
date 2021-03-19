package DFS;

public class RollDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numRollsToTarget(2, 4, 7));
	}
	
	 public static int numRollsToTarget(int d, int f, int target) {
	        int[] ans = new int[1];
	        helper(d, f, target, ans);
	        return ans[0];
	    }
	    public static void helper(int d, int f, int target, int[] ans){
	        if(d == 0){
	            if(target == 0) ans[0] = (ans[0]+1) % 1000000007;
	            return;
	        }
	        for(int i = 1; i <= f; i++){
	            target -= i;
	            helper(d - 1, f, target, ans);
	            target +=i;
	        }
	    }

}
