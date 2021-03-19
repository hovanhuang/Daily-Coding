package Arrays;
import java.util.Arrays;

public class Deduplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deduplicate sol = new Deduplicate();
		int[] input = {1, 1};
		System.out.println(Arrays.toString(sol.dedup(input)));
	}
	 public int[] dedup(int[] array) {
		    // Write your solution here
		    if(array.length <= 1){
		      return array;
		    }
		    int stack = -1;
		    int scan = 0;
		    //stack - [0, stack] is the stack storing elements that are the potential result; when current
		    //scanning element is equals to top of stack, remove the element from stack.

		    //scan - (stack, scan) elements have been scanned. 
		    while(scan < array.length){
		      if(stack == -1 || array[scan] != array[stack]){
		        array[++stack] = array[scan++];
		      }else{
		        while(scan < array.length && array[scan] == array[stack]){
		          scan++;
		        }
		        stack--;
		      }
		    }
		    return Arrays.copyOf(array, stack + 1);
		  }

}
