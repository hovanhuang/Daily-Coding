package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhonePad sol = new PhonePad();
		System.out.println(Arrays.toString(sol.combinations(273)));

	}
	public String[] combinations(int number) {
	    // Write your solution here
	    List<String> resultList = new ArrayList<>();
	    String [] input = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    Map<Integer, String> map = new HashMap<>();
	    for(int i = 0; i < input.length; i++){
	      map.put(i, input[i]);
	    }
	    StringBuilder sb = new StringBuilder();
//	    int[] array = numberProcess(number);
	    String phoneNum = Integer.toString(number);
	    phonePad(resultList,sb, map, 0, phoneNum);
	    String[] result = new String[resultList.size()];
	    result = resultList.toArray(result);
	    return result;
	  }
	  public void phonePad(List<String> resultList,StringBuilder sb, Map<Integer, String> map, int level, String phoneNum){
	    if(level == phoneNum.length()){
	      resultList.add(sb.toString());
	      return;
	    }
	    String select = map.get(Character.getNumericValue(phoneNum.charAt(level)));
	    for(int i = 0; i < select.length(); i++){
	      sb.append(select.charAt(i));
	      phonePad(resultList,sb, map, level + 1, phoneNum);
	      sb.deleteCharAt(sb.length() - 1);
	    }
	  }
	  private int[] numberProcess(int number){
	    int length = 0;
	    int newNum = number;
	    while(number != 0){
	      number = number / 10;
	      length++;
	    }
	    int[] temp = new int[length];
	    while(newNum != 0){
	      temp[length - 1] = newNum % 10;
	      length--;
	      newNum /= 10;
	    }
	    return temp;
	  }

}
