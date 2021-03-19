package BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
	int key;
	TreeNode left;
	TreeNode right;
	TreeNode(int key){
		this.key = key;
	}
}
public class PrintTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintTree sol = new PrintTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(sol.layerByLayer(root));

	}
	public List<List<Integer>> layerByLayer(TreeNode root) {
	    // Write your solution here
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    Queue<TreeNode> helper = new LinkedList<TreeNode>();
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    if(root == null){
	      return list;
	    }
	    queue.offer(root);
	    while(!queue.isEmpty()){
	      List<Integer> subList = new ArrayList<>();
	      helper.offer(queue.poll());
	      while(!helper.isEmpty() && queue.isEmpty()){
	        if(helper.peek().left != null){
	          queue.offer(helper.peek().left);
	        }
	        if(helper.peek().right != null){
	          queue.offer(helper.peek().right);
	        }
	        subList.add(helper.poll().key);
	      }
	      if(helper.isEmpty()){
	        list.add(subList);
	      }
	    }
	    return list;
	  }

}
