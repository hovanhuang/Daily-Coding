package Arrays;
import java.util.ArrayList;
import java.util.List;

public class CommonElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{17,59,60,65,117,118,214},{17,31,36,59,60,65,94,99,111,117,118,126,157,176,214,243,246},{17,39,59,60,65,117,118,153,162,164,214},{17,59,60,65,117,118,214,250},{17,59,60,65,72,77,98,117,118,126,151,178,204,204,208,214}};
		List<Integer> a = CommonElement.commonElementsInKSortedArrays(CommonElement.putArrayToList(input));
		System.out.println(a);
	}
	public static List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
		// Write your solution here
		if(input.size() == 1){
			return input.get(0);
		}
		int size = input.size();
		List<Integer> buffer = twoListCommon(input.get(0), input.get(1));
		List<Integer> result = buffer;
		for(int i = 2; i < size; i++){
			result = twoListCommon(buffer, input.get(i));
			buffer = result;
		}
		return result;

	}
	public static List<Integer> twoListCommon(List<Integer> L1, List<Integer> L2){
		int i = 0;
		int j = 0;
		List<Integer> result = new ArrayList<>();
		while(i < L1.size() && j < L2.size()){
			int one = L1.get(i);
			int two = L2.get(j);
			if(one == two){
				result.add(one);
				i++;
				j++;
			}else if(one < two){
				i++;
			}else{
				j++;
			}
		}
		return result;
	}
	public static List<List<Integer>> putArrayToList(int[][] input){
		int row = input.length;
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < row; i++) {
			List<Integer> list = new ArrayList<>();
			for(int ele: input[i]) {
				list.add(ele);
			}
			result.add(list);
		}
		return result;
	}

}
