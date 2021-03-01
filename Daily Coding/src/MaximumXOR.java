import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// LeetCoe 1707;

public class MaximumXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	class TrieNode{
        TrieNode[] child;
        public TrieNode(){
            child = new TrieNode[2];
        }
    }
    private void insert(TrieNode root, int num){
        for(int i = 31; i >= 0; i--){
            int id = (num >> i) & 1;
            if(root.child[id] == null){
                root.child[id] = new TrieNode();
            }
            root = root.child[id];
        }
    }
    TrieNode root;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            list.add(new int[]{i, queries[i][0], queries[i][1]});
        }
        Collections.sort(list, (a, b)->Integer.compare(a[2], b[2]));
        Arrays.sort(nums);
        root = new TrieNode();
        int id = 0;
        int[] result = new int[queries.length];
        
        for(int i = 0; i < result.length; i++){
            int[] cur = list.get(i);
            while(id < nums.length && nums[id] <= cur[2]){
                insert(root, nums[id++]);
            }
            result[cur[0]] = getMax(root, cur[1]);
        }
        return result;
        
    }
    private int getMax(TrieNode root, int num){
        for(int i = 31; i >= 0; i--){
            if(root == null) return -1;
            int id = ((num >> i) & 1) ^ 1;
            if(root.child[id] != null){
                num |= 1 << i;
                root = root.child[id];
            }else{
                num &= ~(1 << i);
                root = root.child[id ^ 1];
            }
        }
        return num;
    }

}
