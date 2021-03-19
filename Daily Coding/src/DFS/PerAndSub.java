package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerAndSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerAndSub sol = new PerAndSub();
		String input = "rqh";
		System.out.println(sol.allPermutationsOfSubsets(input));

	}
	public List<String> allPermutationsOfSubsets(String set) {
	    // Write your solution here
	    List<String> result = new ArrayList<>();
	    if(set.length() == 0){
	      return result;
	    }
	    StringBuilder sb = new StringBuilder();
	    char[] input = set.toCharArray();
	    allPerAndSub(input, result, 0);
	    return result;
	  }
	  private void allPerAndSub(char[] input, List<String> result, int index){
	    if(index == input.length){
	      result.add(new String(input));
	      return;
	    }
	    result.add(new String(input, 0, index));
	    for(int i = index; i <= input.length - 1; i++){
	      swap(input, index, i);
	      allPerAndSub(input, result, index + 1);
	      swap(input, index, i);
	    }
	  }
	  private void swap(char[] input, int left, int right){
	    char temp = input[left];
	    input[left] = input[right];
	    input[right] = temp;
	  }

}
