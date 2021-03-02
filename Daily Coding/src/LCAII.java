// p and q might not exist

public class LCAII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] found = new TreeNode[1];
        found[0] = null;
        LCAHelper(root, p, q, found);
        return found[0];
    }
    public TreeNode LCAHelper(TreeNode root, TreeNode p, TreeNode q, TreeNode[] found){
        if(root == null){
            return root;
        }
        TreeNode left  = LCAHelper(root.left, p, q, found);
        TreeNode right  = LCAHelper(root.right, p, q, found);
        if(root == q || root == p){
            if(left != null || right != null){
                found[0] = root;
            }  
            return root;
        }else{
            if(left == null && right == null){
                return null;
            }else if(left == null || right == null){
                return left == null ? right : left;
            }else{
                found[0] = root;
            }
            return root;
        }
    }

}
