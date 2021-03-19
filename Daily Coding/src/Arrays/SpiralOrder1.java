package Arrays;
import java.util.Arrays;

public class SpiralOrder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{-85,56,37,48},{-25,-78,-29,62},{18,-60,-74,-84},{90,44,5,1}};
		int bound = arr.length;
		int i = 0;
		int j = 0;
		int count = 0;
		int iterate = 0;
		int[] result = new int[arr.length * arr[0].length];
		int index = 0;
		
		while (bound > 0) {
			if(iterate % 2 == 0) {
				for(j = j; j <= bound - 1;j++) {
					result[index++] = arr[i][j];
				}
				bound--;
				for(i = i + 1; i <= bound; i++){
					result[index++] = arr[i][j];
				}
				iterate++;	
			}else {
				for(j = j -1; j >= arr.length - bound; j--) {
					result[index++] = arr[i][j]; 
				}
				bound--;
				for(i = i - 1; i >= arr.length - bound - 1; i--) {
					result[index++] = arr[i][j];
				}
				iterate++;	
			}

		}
		System.out.println(Arrays.toString(result));
	
	}

}
