package DFS;
import java.util.ArrayList;
import java.util.List;

public class UnviersityEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnviersityEvent sol = new UnviersityEvent();
		String input = "ABCD";
		System.out.println(sol.event(input));
	}
	public List<String> event(String input){
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(result, sb, 0, input);
		return result;
	}
	public void helper(List<String> result, StringBuilder sb, int index, String input){
		if(index == input.length()){
			char temp = sb.charAt(sb.length() - 1);
//			if(temp == 'x'){
//				return;
//			}else {
				result.add(sb.toString());
				return;
//			}
		}
		// only adding character from the string to potential result
		sb.append(input.charAt(index));
		helper(result, sb, index + 1, input);
		sb.deleteCharAt(sb.length() - 1);

		//adding character from the string and ‘x’ to the result;
		if(index < input.length() -1) {
			sb.append(input.charAt(index)).append('x');
			helper(result, sb, index + 1, input);
			sb.delete(sb.length() - 2, sb.length());
		}
	}


}
