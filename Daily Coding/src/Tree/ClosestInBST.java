package Tree;

public class ClosestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestInBST sol = new ClosestInBST();
		String[] input = {"10","5","15","2","9","11","23","1","#","6","#","#","12","21","25"};
		TreeNode root = new TreeNode(0);
		root = BuildTree.build(input, root, 0);
		System.out.println(sol.closestMain(root, 13, 0, Integer.MAX_VALUE));
	}
	private int closestMain(TreeNode root, int target, int num, int minDiff){
	    if(root == null){
	      return num;
	    }
	    if(root.key == target){
	      num = root.key;
	      return num;
	    }else if(root.key > target){
	      if(minDiff > Math.abs(root.key - target)){
	        minDiff = Math.abs(root.key - target);
	        num = root.key;
	      }
	      return closestMain(root.left, target, num, minDiff);
	    }else{
	      if(minDiff > Math.abs(root.key - target)){
	        minDiff = Math.abs(root.key - target);
	        num = root.key;
	      }
	      return closestMain(root.right, target, num, minDiff);
	    }
	  }
}
