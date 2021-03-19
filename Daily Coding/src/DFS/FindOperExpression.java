package DFS;

public class FindOperExpression {
	static char[] signs = {'+', '-', '*', '/'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  input = {3, 5, 7};
		System.out.println(findOperExpression(input, -15));
	}
	public static String findOperExpression(int[] input, int target) {
		int n = input.length;
		StringBuilder sb = new StringBuilder();
		sb.append(input[0]);
		String result = "";
		result = helper(input, 1, n, target, sb, result);
		if(result.length() ==0) {
			sb.delete(0, sb.length());
			sb.append('-').append(input[0]);
			result = helper(input, 1, n, target, sb, result);
		}
		return result;
		
	}
	public static String helper(int[] input, int index, int n, int target, StringBuilder sb, String result) {
		if(index == n) {
			int ans = calculator(sb.toString());
			if(target == ans) {
				result = sb.toString();
				return result;
			}
			return "";
		}
		for(int i = 0; i < signs.length; i++) {
			int size = sb.length();
			sb.append(signs[i]);
			sb.append(String.valueOf(input[index]));
			result = helper(input, index + 1, n, target, sb, result);
			if(result.length() > 0) return result;
			sb.delete(size, sb.length());
		}		
		return "";
		
	}
	// 3    +      10 - 5 + 3
	//last  sign  curN  i
	public static int calculator(String input) {
		input = input.replaceAll("\\s+", "");
		char sign = '+';
		int last = 0, curNum = 0, result = 0;
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(Character.isDigit(c)) {
				curNum = curNum * 10 + (c - '0');
			}
			if(!Character.isDigit(c) || i == input.length() - 1) {
				if(sign == '+') {
					result += last;
					last = curNum;
				}
				if(sign == '-') {
					result += last;
					last = -curNum;
				}
				if(sign == '*') {
					last = last * curNum;
				}
				if(sign == '/') {
					last = last / curNum;
				}
				sign = c;
				curNum = 0;
			}
		}
		return result + last;
	}
	

}
