package DFS;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public int key;
	public TreeNode(int key){
		this.key = key;
	}
}

public class PostTraversal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		System.out.println(postOrder(root));

	}
	public static List<Integer> postOrder(TreeNode root) {
		// Write your solution here
		List<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while(!stack.isEmpty()){
			TreeNode cur = stack.peekFirst();
			if(cur.left != null && cur.left != prev && (cur.right == null|| cur.right != prev)){
				cur = cur.left;
				stack.offerFirst(cur);
			}else if(cur.right != null && cur.right != prev){
				cur = cur.right;
				stack.offerFirst(cur);
			}else{
				result.add(stack.pollFirst().key);
			}
			prev = cur;
		}
		return result;
	}

}
