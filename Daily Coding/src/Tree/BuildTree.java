package Tree;
class TreeNode{
	TreeNode left;
	TreeNode right;
	TreeNode next;
	int key;
	TreeNode(int key){
		this.key = key;
		this.left = null;
		this.right = null;
	}
}
public class BuildTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"10","5","15","2","9","11","23","1","#","6","#","#","12","21","25"};
		TreeNode root = new TreeNode(Integer.parseInt(input[0]));
		root = build(input, root, 0);
	}
	//return TreeNode is the new node created from the i index element of input array.
	public static TreeNode build(String[] nodeList, TreeNode root, int i) {
		if(i < nodeList.length && nodeList[i] != "#") {
			TreeNode newNode = new TreeNode(Integer.parseInt(nodeList[i]));
			root = newNode;
			root.left = build(nodeList, root.left, i*2 + 1);
			root.right = build(nodeList, root.right, i*2 + 2);
		}
		return root;
	}
}
