package BFS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienDict sol = new AlienDict();
		String[] words = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
		System.out.print(sol.alienOrder(words));
	}
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		// extract the relationships between characters;
		for(String str : words){
			for(char c : str.toCharArray()){
				map.put(c, new HashSet<>());
			}
		}
		for(int i = 1; i < words.length; i++) {
			String word1 = words[i - 1];
			String word2 = words[i];
			if(word1.length() > word2.length() && word1.startsWith(word2)){
				return "";
			}
			int j = 0;
			int length = Math.min(word1.length(), word2.length());
			while(j < length && words[i - 1].charAt(j) == words[i].charAt(j)){
				j++;
			}
			if(j < length){
				map.get(word1.charAt(j)).add(word2.charAt(j));
			}
		}
		// count incoming edges;
		Map<Character, Integer> incoming = new HashMap<>();
		for(Map.Entry<Character, Set<Character>> ele: map.entrySet()){
			incoming.put(ele.getKey(), incoming.getOrDefault(ele.getKey(), 0));
			for(Character c: ele.getValue()){
				incoming.put(c, incoming.getOrDefault(c, 0) + 1);
			}
		}
		// start putting non-dependency node into Queue and start BFS
		for(Map.Entry<Character, Integer> entry : incoming.entrySet()) {
			if(entry.getValue() == 0) {
				queue.offer(entry.getKey());
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			Character c = queue.poll();
			if(map.get(c) != null) {
				for(Character nei : map.get(c)) {
					int inEdge = incoming.get(nei);
					if(inEdge == 1) {
						queue.offer(nei);
						incoming.put(nei,inEdge - 1);
					}else {
						incoming.put(nei,inEdge - 1);
					}
				}
			}
			sb.append(c);
		}
		if (sb.length() < incoming.size()) {
			return "";
		}
		return sb.toString();
	}

}
