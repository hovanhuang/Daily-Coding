package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubsetII sol = new AllSubsetII();
		String set = "abbb";
		System.out.println(Arrays.toString(sol.subSets(set).toArray()));
	}
	public List<String> subSets(String set) {
	    // Write your solution here.
	    List<String> result = new ArrayList<>();
	    if(set == null){
	      return result;
	    }
	    StringBuilder sb = new StringBuilder();
	    char[] charArr = set.toCharArray();
	    Arrays.sort(charArr);
	    subSetsII(result, sb, 0, charArr);
	    return result;
	  }
	  private void subSetsII(List<String> result, StringBuilder sb, int index, char[] charArr){
	    if(index == charArr.length){
	      result.add(sb.toString());
	      return;
	    }
	    sb.append(charArr[index]);
	    subSetsII(result,sb, index + 1, charArr);
	    sb.deleteCharAt(sb.length() - 1);

	    while(index < charArr.length - 1 && charArr[index] == charArr[index + 1]){
	      index++;
	    }
	    subSetsII(result,sb, index + 1, charArr);
	  }

}
