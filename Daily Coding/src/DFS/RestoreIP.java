package DFS;
import java.util.ArrayList;
import java.util.List;

public class RestoreIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIP sol = new RestoreIP();
		String input = "10000";
		System.out.println(sol.Restore(input));

	}
	public List<String> Restore(String ip) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		if(ip.length() == 0){
			return result;
		}
		StringBuilder sb = new StringBuilder();
		char[] input = ip.toCharArray();
		restoreMain(input, result, sb, 0, 0);
		return result;
	}
	private void restoreMain(char[] input, List<String> result, StringBuilder sb, int offset, int index){
		if(index == 4) {
			if(sb.length() == input.length + 4){
				result.add(sb.substring(0, sb.length() - 1));
			}
			return;
		}
		if(offset < input.length) {
			restoreMain(input, result, sb.append(input[offset]).append('.'), offset + 1, index + 1);
			sb.delete(sb.length() - 2, sb.length());
		}
		if(offset + 1 < input.length) {
			char a = input[offset];
			char b = input[offset + 1];
			if(a != '0') {
				restoreMain(input, result, sb.append(a).append(b).append('.'), offset + 2, index + 1);
				sb.delete(sb.length() - 3, sb.length());
			}
			
		}
		if(offset + 2 < input.length) {
			char a = input[offset];
			char b = input[offset + 1];
			char c = input[offset + 2];
			if(a == '1' || a == '2' && b >= '0' && b <= '4' || a =='2' && b == '5' && c >= '0' && c <= '5') {
				restoreMain(input, result, sb.append(a).append(b).append(c).append('.'), offset + 3, index + 1);
				sb.delete(sb.length() - 4, sb.length());
			}
		}
	}

}
