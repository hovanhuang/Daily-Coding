package Tree;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumToTarget sol = new SumToTarget();
		TreeNode root = new TreeNode(0);
		String[] input = {"-1", "-2","-6", "-3", "-3", "#", "#", "-7", "-8","-5","#"};
		root = BuildTree.build(input, root, 0);
		System.out.println(sol.exist(root,  -100));
	}
	public boolean exist(TreeNode root, int target) {
		// Write your solution here
		List<Integer> prefix = new ArrayList<>();
		return sumToTarget(root, prefix, target);
	}
	private boolean sumToTarget(TreeNode root, List<Integer> prefix, int target){
		if(root == null){
			Set<Integer> set = new HashSet<>();
			for(Integer ele : prefix){
				if(set.contains(ele - target) || ele == target){
					return true;
				}
				set.add(ele);
			}
			return false;
		} 
		if(root.key == target){
			return true;
		}
		if(prefix.isEmpty()){
			prefix.add(root.key);
		}else{
			int curSum = prefix.get(prefix.size() - 1);
			prefix.add(curSum + root.key);
		}
		if(sumToTarget(root.left, prefix, target)) {
			return true;
		}
		if(sumToTarget(root.right, prefix, target)){
			return true;
		}
		prefix.remove(prefix.size() - 1);
		return false;
	}

}
