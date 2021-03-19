package DP;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII sol = new WordBreakII();
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		String[] wordArr = {"cat","cats","and","sand","dog"};
		for(String str : wordArr) {
			wordDict.add(str);
		}
		System.out.println(sol.wordBreak(s, wordDict));
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<List<String>> M = new ArrayList<>();
        M.add(new ArrayList<>());
        for(int i = 1; i <= s.length(); i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < i; j++){
                String right = s.substring(j, i);
                if(set.contains(right)){
                    temp = addWord(M.get(j), right, temp);
                }
            }
            M.add(temp);
        }
        return M.get(s.length()); 
    }
    private List<String> addWord(List<String> list, String str, List<String> result){
        int size = list.size();
        if(size == 0){
            result.add(str);
            return result;
        }
        for(String ele : list){
            result.add(ele + " " + str);
        }
        return result;
    }

}
