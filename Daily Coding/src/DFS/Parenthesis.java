package DFS;
import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parenthesis sol = new Parenthesis();
		
		System.out.println(sol.validParentheses(3));
	}
	public List<String> validParentheses(int n) {
		// Write your solution here
		StringBuilder solution = new StringBuilder();
		List<String> stringList = new ArrayList<>();
		findParentheses(n, stringList, 0, 0, solution);
		return stringList;
		
	}
	public List<String> findParentheses(int n, List<String> stringList, int left, int right, StringBuilder solution){
		if(left == n && right == n) {
			stringList.add(solution.toString());
			return stringList;
		}
		if(left < n) {
			solution.append("(");
			findParentheses(n, stringList, left + 1, right, solution);
			solution.deleteCharAt(solution.length() -1);
		}

		if(left > right && right < n) {
			solution.append(")");
			findParentheses(n, stringList, left, right + 1, solution);
			solution.deleteCharAt(solution.length() -1);
		}
		return stringList;
		
		
	}

}
