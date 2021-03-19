package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of integers, return an array of integers which contains
//[1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)]
// input: [1,6,8,5,9,4,7,2]
//                       i
//sum 7
//count 1
// output: [1,14,18,9]
public class SumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,6,8,5,9,4,7,2,1,4,5};
		SumOfArray sol = new SumOfArray();
		System.out.println(Arrays.toString(sol.sumOfArray(input)));
	}
	public int[] sumOfArray(int[] input) {
		if(input == null || input.length == 0) {
			return new int[0];
		}
		int numOfSum = 1;
		int id = 0;
		int count = 0;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		while(id < input.length) {
			sum += input[id];
			count++;
			if(count == numOfSum) {
				list.add(sum);
				numOfSum++;
				count = 0;
				sum = 0;
			}
			id++;
		}
		if(count != 0) list.add(sum);
		int[] result = new int[list.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
