import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem sol = new AutocompleteSystem(input, times);
	}
	 class TrieNode{
	        Map<Character, TrieNode> child;
	        Map<String, Integer> words;
	        boolean isSentence;
	        public TrieNode(){
	            child = new HashMap<>();
	            words = new HashMap<>();
	        }
	    }
	    public void insert(TrieNode root, String input){
	        TrieNode cur = root;
	        for(int i = 0; i < input.length(); i++){
	            TrieNode next = cur.child.get(input.charAt(i));
	            if(next == null){
	                next = new TrieNode();
	                cur.child.put(input.charAt(i), next);

	            }
	            cur.words.put(input, cur.words.getOrDefault(input, 0) + 1);
	            cur = next;
	        }
	        cur.words.put(input, cur.words.getOrDefault(input, 0) + 1);
	        cur.isSentence = true;
	    }
	    TrieNode curNode;
	    TrieNode root;
	    StringBuilder sb;
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        root = new TrieNode();
	        curNode = root;
	        sb = new StringBuilder();
	        for(int i = 0; i < sentences.length; i++){
	            for(int j = 0; j < times[i]; j++){
	                insert(root, sentences[i]);    
	            }
	        }
	    }
	    public List<String> input(char c) {
	        List<String> result = new ArrayList<>();
	        PriorityQueue<Map.Entry<String, Integer>> maxFreq = new PriorityQueue<>(new Comparator<>(){
	            @Override
	            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
	                int i1 = e1.getValue();
	                int i2 = e2.getValue();
	                if(i1 == i2){
	                    return e1.getKey().compareTo(e2.getKey());
	                }else{
	                    return Integer.compare(i2, i1);
	                }
	             }
	         });
	        if(c != '#'){
	            sb.append(c);
	            if(curNode != null) curNode = curNode.child.get(c);
	            if(curNode != null){
	                for(Map.Entry<String, Integer> entry : curNode.words.entrySet()){
	                    maxFreq.offer(entry);
	                }
	            }else{
	                return result;
	            }
	            int count = 3;
	            while(!maxFreq.isEmpty() && count > 0){
	                result.add(maxFreq.poll().getKey());
	                count--;
	            }
	        }else{
	            insert(root, sb.toString());
	            sb.delete(0, sb.length());
	            curNode = root;
	        }
	        return result;
	        
	    }
}
