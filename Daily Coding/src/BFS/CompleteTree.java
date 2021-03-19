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
public class CompleteTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompleteTree sol = new CompleteTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(sol.isCompleted(root));

	}
	public boolean isCompleted(TreeNode root) {
	    // Write your solution here
	    if(root == null){
	      return true;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    boolean temp = false;
	    while (!queue.isEmpty()){
	        TreeNode tempNode = queue.poll();
	        if(tempNode.left != null){
	          if(temp){
	            return false;
	          }else{
	            queue.offer(tempNode.left);
	          }
	        }else if(tempNode.left == null){
	          temp = true;
	        }
	        if(tempNode.right != null){
	          if(temp){
	            return false;
	          }else{
	            queue.offer(tempNode.right);
	          }
	        }else if(tempNode.right == null){
	          temp = true;
	        }
	    }
	    return true;
	  }

}
