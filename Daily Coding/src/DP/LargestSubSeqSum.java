package DP;

public class LargestSubSeqSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] treeLayer = {100, 2, -1, 4, 134, 32, 31};
		int[] M = new int[treeLayer.length];
		M[0] = treeLayer[0];
		M[1] = treeLayer[1];

		for(int i = 2; i < treeLayer.length; i++){
			int globalMax = 0;
			for(int j = i - 2; j >= 0; j--){
				int temp = M[j] < 0? treeLayer[i] : M[j] + treeLayer[i];
				globalMax = Math.max(globalMax, temp);
			}
			M[i] = globalMax;
		}
		System.out.println(M[treeLayer.length-1]);

	}

}
