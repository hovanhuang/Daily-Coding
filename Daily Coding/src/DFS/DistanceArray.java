package DFS;
import java.util.Arrays;

public class DistanceArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistanceArray sol = new DistanceArray();
		System.out.println(Arrays.toString(sol.keepDistance(3)));
	}
	public int[] keepDistance(int k) {
		// Write your solution here.
		int[] result = new int[2 * k];
		return distanceArray(result, k, k)? result : null;
	}
	private boolean distanceArray(int[] result, int k, int curK){
		if(curK == 0){
			return true;
		}
		for(int i = 0; i <= 2*k - curK - 2; i++){
			if(result[i] == 0 && result[i + curK + 1] == 0){
				result[i] = curK;
				result[i + curK + 1] = curK;
				if(distanceArray(result, k, curK - 1)){
					return true;
				}
				result[i] = 0;
				result[i + curK + 1] = 0;
			}
		}
		return false;
	}

}
