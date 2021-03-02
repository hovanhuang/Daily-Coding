import java.util.HashSet;
import java.util.Set;

//given parent pointer

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
public class LCAIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        set.add(p);
        while(p.parent != null){
            set.add(p.parent);
            p = p.parent;
        }
        if(set.contains(q)) return q;
        while(q.parent != null){
            if(set.contains(q.parent)){
                return q.parent;
            }
            q = q.parent;
        }
        return null;
    }

}
