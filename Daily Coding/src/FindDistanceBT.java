//Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.
//
//The distance between two nodes is the number of edges on the path from one to the other.
public class FindDistanceBT {
	int found = 0;
    int ans = 0;
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q) return 0;
        if(root == null){
            return -1;
        }
        int left = findDistance(root.left, p, q);
        int right = findDistance(root.right, p, q);
        if(found == 2 && ans != 0) return ans;
        if(root.val == p || root.val == q){
            found++;
            if(found == 2){
                ans = Math.max(left, right) + 1;
                return ans;
            }
            return Math.max(left, right) + 1;
        }else if(left < 0 && right < 0){
            return left;
        }else if(left < 0 || right < 0){
            return left < 0 ? right + 1 : left + 1;
        }else{
            ans = left + right + 2;
            return ans;
        }
    }
}
