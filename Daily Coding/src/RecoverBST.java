//You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
//
//Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
public class RecoverBST {
	TreeNode max = new TreeNode(Integer.MAX_VALUE);
	TreeNode min = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		boolean[] check = new boolean[1];
		while(!check[0]){
			check[0] = true;
			helper(root, max, min, check);
		}
	}
	private void helper(TreeNode root, TreeNode max, TreeNode min, boolean[] check){
		if(root == null){
			return;
		}
		if(root.val > max.val){
			int temp = root.val;
			root.val = max.val;
			max.val = temp;
			check[0] = false;
		}
		if(root.val < min.val){
			int temp = root.val;
			root.val = min.val;
			min.val = temp;
			check[0] = false;
		}
		helper(root.left, root, min, check);
		helper(root.right, max, root,check);
	}
}
