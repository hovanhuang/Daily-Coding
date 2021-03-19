package Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTGivenRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTGivenRange sol = new BSTGivenRange();
		TreeNode root = new TreeNode(0);
		String[] input = {"10", "6", "15", "2", "7", "11", "18", "1", "3","7","8", "10", "12", "16", "20"};
		root = BuildTree.build(input, root, 0);
		List<Integer> result = new ArrayList<>();
		int[] step = new int[1];
		step[0] = 0;
		System.out.println(Arrays.toString(sol.givenRange(root, 11, 14, result, step).toArray()));
		System.out.println(step[0]);
	}	
	
	public List<Integer> givenRange(TreeNode root, int min, int max, List<Integer> result, int[] step){
		if(root == null){
			return result;
		}
		step[0] += 1;
		if(root.key < min){
			givenRange(root.right, min, max, result, step);
		}else if(root.key > max){
			givenRange(root.left, min, max, result, step);
		}
		if(root.key >= min && root.key <= max){
			result.add(root.key);
			step[0] += 1;
			givenRange(root.left, min, max, result, step);
			givenRange(root.right, min, max, result, step);
		}
		return result;
//		step[0] += 1;
//		if(root.key >= min && root.key <= max){
//			result.add(root.key);
//		}
//		givenRange(root.left, min, max, result, step);
//		givenRange(root.right, min, max, result, step);
//		return result;
	}
}
