import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Input: words = ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]]
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        List<List<Integer>> list = new ArrayList<>();
        
        for(String s : words){
            int curId = map.get(s);
            String reverseS = new StringBuilder(s).reverse().toString();
            if(map.containsKey(reverseS) && map.get(reverseS) != curId){
                list.add(Arrays.asList(curId, map.get(reverseS)));
            }
            for(String prefix : allPrefix(s)){
                String reverseW = new StringBuilder(prefix).reverse().toString();
                if(map.containsKey(reverseW)){
                    list.add(Arrays.asList(curId, map.get(reverseW)));
                }
            }
            for(String suffix : allsuffix(s)){
                String reverseW = new StringBuilder(suffix).reverse().toString();
                if(map.containsKey(reverseW)){
                    list.add(Arrays.asList(map.get(reverseW), curId));
                }
            }
        }
        return list;
    }
    
    private List<String> allPrefix(String word){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            if(isPalindrome(word, i, word.length() - 1)){
                result.add(word.substring(0, i));
            }
        }
        return result;
    }
    private List<String> allsuffix(String word){
        List<String> result = new ArrayList<>();
        for(int i = word.length() - 1; i >= 0; i--){
            if(isPalindrome(word, 0, i)){
                result.add(word.substring(i + 1, word.length()));
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String word, int from, int to){
        while(from <= to){
            if(word.charAt(from++) != word.charAt(to--)) return false;
        }
        return true;
    }

}
