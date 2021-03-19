package BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Neighbor{
	private Map<String, Integer> wordIndex = new HashMap<>();
	private List<String> wordList;
	public Neighbor(List<String> wordList){
		for(int i = 0; i < wordList.size(); i++) {
			String word = wordList.get(i);
			wordIndex.put(word, i);
		}
		this.wordList = wordList;
	}
	public List<String> findNeighbor(int index){
		String cur = wordList.get(index);
		StringBuilder sb = new StringBuilder(cur);
		List<String> nei = new ArrayList<>();
		for(int i = 0; i < sb.length(); i++) {
			char orig = cur.charAt(i);
			for(char c = 'a'; c <= 'z'; c++ ) {
				if(c == orig) {
					continue;
				}
				sb.setCharAt(i, c);
				if(wordIndex.containsKey(sb.toString())) {
					nei.add(sb.toString());
				}
			}
			sb.setCharAt(i, orig);
		}
		return nei;
	}
	public int getIndex(String input) {
		if(wordIndex.containsKey(input)) {
			return wordIndex.get(input);
		}else {
			return -1;
		}
	}
}
public class WordLadder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"izvcnt","hyjwgb","luzvff","illbjg","iehfzp","jjofku","tmkrma","yrrvpq","ntijqd","lbruez","jtoimy","fgktfq","tmtibx","vujkns","fjdeds","cicrlt","lkupnp","kbquoc","vaqnwd","sybbkk","voifyl","zycdrm","yxfkyg","tusvnf","bfffsq","oxqtaq","slynkf","eiamsy","cxmvkt","xsmdmi","jckoeq","zxpjjf","ndjdtk","xvqomc","hmqrlq","nwmoyw","swomhn","tqrljp","ruwdbe","hgliyu","cclull","fpeltr","kivdkq","puuqfh","kdjnrw","ceuvpm","axnoct","kfxhjj","mhvqjv","kmhlgy","avgxno","jiqrjj","rkiyyt","pjvjuf","twlwjy","mdjlug","nqmteo","mbqith","unfgkn","snvcok","ytjezq","jzbgdm"};
		WordLadder sol = new WordLadder();
//		String[] input = {"git", "hit", "hog", "hot"};
		List<String> wordInput = Arrays.asList(input);
		String begin = "cclull";
		String end = "kfxhjj";
//		String begin = "git";
//		String end = "hot";
		System.out.println(sol.ladderLength(begin, end, wordInput));
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// Write your solution here
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>(wordList);
		list.add(beginWord);
		Neighbor find = new Neighbor(list);
		if(find.getIndex(endWord) == -1) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(endWord);
		map.put(endWord, 0);
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			int steps = map.get(cur);
			List<String> nei = find.findNeighbor(find.getIndex(cur));
			for(String str : nei) {
				if(!map.containsKey(str)) {
					map.put(str, steps + 1);
					queue.offer(str);
				}
			}
		}
		return map.getOrDefault(beginWord, 0);
	}

}
