import java.util.HashSet;
import java.util.Set;

// find LCA for nodes
public class LCAIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> nodeSet = new HashSet<>();
        for(TreeNode node : nodes){
            nodeSet.add(node);
        }
        return helper(root, nodeSet);
        
    }
    private TreeNode helper(TreeNode root, Set<TreeNode> nodeSet){
        if(root == null){
            return root;
        }
        TreeNode left = helper(root.left, nodeSet);
        TreeNode right = helper(root.right, nodeSet);
        if(nodeSet.contains(root) || left != null && right != null){
            return root;
        }else if(left == null || right == null){
            return left == null? right : left;
        }else{
            return null;
        }
    }

}
