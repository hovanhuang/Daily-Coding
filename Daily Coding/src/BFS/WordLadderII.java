package BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		String[] word = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(word));
		WordLadderII sol = new WordLadderII();
		System.out.println(sol.findLadders(beginWord, endWord, wordList));
	}
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(endWord == null || endWord.length() == 0 || !wordSet.contains(endWord)){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> path = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);
        visited.add(endWord);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            List<String> neighbors = findNeighbor(cur, wordSet, visited);
            for(String s : neighbors){
                if(!visited.contains(s)){
                    queue.offer(s);
                    visited.add(s);
                }
                if(path.get(s) == null){
                    List<String> temp = new ArrayList<>();
                    temp.add(cur);
                    path.put(s, temp);
                }else{
                    path.get(s).add(cur);
                }
            }
        }
        if(path.get(beginWord) == null) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        dfs(beginWord, path, result, new ArrayList<>(), endWord);
        return result;
    }
    public void dfs(String input, HashMap<String, List<String>> path,List<List<String>> result, List<String> curPath, String endWord){
        if(input.equals(endWord)){
            curPath.add(endWord);
            result.add(new ArrayList<>(curPath));
            return;
        }
        curPath.add(input);
        for(String s : path.get(input)){
            dfs(s, path, result, curPath, endWord);
        }
        curPath.remove(curPath.size() - 1);
    }
    public List<String> findNeighbor(String input, Set<String> wordSet, Set<String> visited){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            for(int j = 0; j < 26; j++){
                char cur = (char)(j + 'a');
                if(c == cur) continue;
                sb.setCharAt(i, cur);
                if(wordSet.contains(sb.toString()) && !visited.contains(sb.toString())){
                    result.add(sb.toString());
                }
            }
            sb.setCharAt(i, c);
        }
        return result;
    }


}
