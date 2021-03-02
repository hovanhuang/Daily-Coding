
public class LCABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }
        int rV = root.val;
        int pV = p.val; // large
        int qV = q.val; // small
        if(pV < qV) return lowestCommonAncestor(root, q, p);
        if(rV < pV && qV < rV){
            return root;
        }else if(pV < rV){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
