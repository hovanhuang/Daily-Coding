package DFS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllSubSetIINoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubSetIINoSort sol = new AllSubSetIINoSort();
		String input = "abba";
		System.out.print(sol.subSets(input));

	}
	public List<String> subSets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		if(set == null){
			return result;
		}
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < set.length(); i++){
			Integer temp = map.get(set.charAt(i));
			temp = temp == null? 1 : temp + 1;
			map.put(set.charAt(i), temp);
		}
		char[] input = new char[map.size()];
		int[] count = new int[map.size()];
		int i = 0;
		for(Map.Entry<Character, Integer> ele : map.entrySet()){
			input[i] = ele.getKey();
			count[i] = ele.getValue();
			i++;
		}
		subSetII(input, count, 0, result, sb);
		return result;

	}
	public void subSetII(char[] input, int[] count, int index, 
			List<String> result, StringBuilder sb){
		if(index == input.length){
			result.add(sb.toString());
			return;
		}
		subSetII(input, count, index + 1, result, sb);
		for(int i = 1; i <= count[index]; i++){
			sb.append(addString(input[index], i));
			subSetII(input, count, index + 1, result, sb);
			sb.delete(sb.length() - i, sb.length());
		}
	}
	public String addString(char c, int number) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= number; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

}
