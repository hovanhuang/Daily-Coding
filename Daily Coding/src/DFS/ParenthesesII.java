package DFS;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParenthesesII {
	private String[] parenthese = {"(", ")","<", ">", "{", "}"};
	public static void main(String[] args) {
		ParenthesesII sol = new ParenthesesII();
		int l = 2, m = 2, n = 1;
		System.out.println(sol.validParentheses(l, m, n));

	}
	public List<String> validParentheses(int l, int m, int n) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Deque<String> stack = new ArrayDeque<>();
		int[] remain = {l, l, m, m,n, n};
		allParentheses(result, sb,stack, remain, 2*(l+m+n));
		return result;

	}
	private void allParentheses(List<String> result, StringBuilder sb, Deque<String> stack, 
			  int[] remain, int total){
		if(total == 0) {
			result.add(sb.toString());
			return;
		}
		for(int i = 0; i <= parenthese.length - 1; i++) {
			if(i % 2 == 0) {
				if(remain[i] > 0) {
					sb.append(parenthese[i]);
					stack.offerFirst(parenthese[i]);
					remain[i]--;
					allParentheses(result, sb, stack, remain, total - 1);
					sb.deleteCharAt(sb.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			}else {
				if(stack.peekFirst() == parenthese[i - 1]) {
					sb.append(parenthese[i]);
					stack.pollFirst();
					allParentheses(result, sb, stack, remain, total - 1);
					sb.deleteCharAt(sb.length() - 1);
					stack.offerFirst(parenthese[i - 1]);
				}
			}
		}
	}
}
