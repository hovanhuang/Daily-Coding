package Tree;

public class NextRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextRight sol = new NextRight();
		String[] input = {"2","1","3","0","7","9","1","2","#","1","10","#","#","#", "#"};
		TreeNode root = new TreeNode(Integer.parseInt(input[0]));
		root = BuildTree.build(input, root, 0);
		sol.connect(root);
	}
	public TreeNode connect(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            TreeNode cur = root;
            while(cur.next != null){
                cur = cur.next;
                if(cur.left != null || cur.right != null){
                    break;
                }
            }
            if(cur != root){
                TreeNode connect = cur.left == null ? cur.right : cur.left;
                root.right.next = connect;
            }  
        }
        if(root.left == null || root.right == null){
            TreeNode temp = root.left == null ? root.right : root.left;
            TreeNode cur = root;
            while(cur.next != null){
                cur = cur.next;
                if(cur.left != null || cur.right != null){
                    break;
                }
            }
            if(cur != root){
                TreeNode connect = cur.left == null ? cur.right : cur.left;
                temp.next = connect;
            }  
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

}
