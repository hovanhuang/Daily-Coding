package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abc";
		char[] charArr = input.toCharArray();
//		System.out.println(charArr);
//		String newS = charArr.toString();
		List<String> list = new ArrayList<>();
//		list.add(new String(charArr.toString()));
		System.out.println(permutations(input));
		list.add(Arrays.toString(charArr));
//		System.out.println(list);
		

	}
	public static List<String> permutations(String input) {
		// Write your solution here
		char[] charArr = input.toCharArray();
		List<String> list = new ArrayList<>();
		return allPer(charArr, 0, list);
	}
	
	static List<String> allPer(char[] input, int index, List list){
		if(index == input.length) {
			list.add(new String(input));
			return list;
		}
		for(int i = index; i <= input.length - 1; i++) {
			swap(input, index, i);
			allPer(input, index + 1, list);
			swap(input, index, i );
		}
		return list;
	}
	static char[] swap(char[] input, int leftSide, int rightSide) {
		char temp;
		temp = input[leftSide];
		input[leftSide] = input[rightSide];
		input[rightSide] = temp;
		return input;
	}
}
