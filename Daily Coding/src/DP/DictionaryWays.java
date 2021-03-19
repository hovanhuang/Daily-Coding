package DP;
import java.util.HashSet;
import java.util.Set;


//Given an input String and a dictionary of words(which are also Strings).

//Find the number of ways that you can cut the input into partitions and each partition is in the dictionary.
public class DictionaryWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryWays sol = new DictionaryWays();
		String input = "cats";
		String[] dict = {"ca", "c", "a", "t", "s"};
		System.out.println(sol.findCut(input,  dict));

	}
	public int findCut(String input, String[] dict){
		Set<String> set = new HashSet<>();
		for(String str : dict){
			set.add(str);
		}
		int[] M = new int[input.length()];
		if(set.contains(input.substring(0, 1))){
			M[0] = 1; 
		}else{
			M[0] = 0;
		}
		for(int i = 1; i < input.length(); i++){
			int cuts = 0;
			for(int j = i; j >= 0; j--){
				if(j > 0){
					if(set.contains(input.substring(j, i + 1))){ 
						cuts = cuts + M[j - 1];
					}
				}else{
					if(set.contains(input.substring(j, i + 1))){
						cuts = cuts + 1; 
					}
				}
			}
			M[i] = cuts;
		}
		return M[input.length() - 1];
	}

}
